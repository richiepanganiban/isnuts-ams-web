package com.orangeandbronze.ams

import grails.converters.JSON

import com.google.gson.Gson

class WebServiceController {

	Gson gson = new Gson();
	
    def getMobileServices = {
		def result = []
		MobileService.findAllByPublished(true, [sort: "title", order: "asc"]).each {
			def mobileService = it
			def mobileServiceMap = [activePromo: mobileService.activePromo, serviceType:mobileService.serviceType.toString(),
				title:mobileService.title, description:mobileService.description, serviceNumber:mobileService.serviceNumber, 
				appendMobileToServiceNumber:mobileService.appendMobileToServiceNumber ]
			def keywordItems = []
			mobileService.keywordItems.each {
				def keywordItem = it
				def keywordItemMap = [itemType:keywordItem.itemType.toString()]
				if (keywordItem.itemType != KeywordItemType.SPACE && 
					keywordItem.itemType != KeywordItemType.LITERAL) {
					keywordItemMap['label'] = keywordItem.label
				}
				if (keywordItem.itemType == KeywordItemType.LITERAL) {
					keywordItemMap['literalValue'] = keywordItem.literalValue
				}
				keywordItems << keywordItemMap
			}
			def categories = []
			mobileService.categories.each {
				def category = it
				categories << category.name
			}
			mobileServiceMap['keywordItems'] = keywordItems
			mobileServiceMap['categories'] = categories
			result << mobileServiceMap
		}
		renderBean(result) 
	}
	
	def getMobileServiceCategories = {
		def categories = MobileServiceCategory.listOrderByName()
		def result = []
		categories.each {
			def category = it
			result << [id:category.id, version:category.version, name:category.name]
		}
		renderBean(result)
	}

	def getFeaturedMobileServices = {
		def featuredServices = FeaturedMobileService.listOrderByPriority()
		def result = []
		featuredServices.each {
			def featuredService = it
			result << ["mobileServiceInstance.id":featuredService.mobileServiceInstance.id, priority:featuredService.priority]
		}
		renderBean(result)
	}

	def renderBean(bean) {
		render gson.toJson(bean)
	}

}
