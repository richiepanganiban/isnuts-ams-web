package com.orangeandbronze.ams

import grails.converters.XML
import grails.converters.JSON

class WebServiceController {

    def getMobileServices = {
		def result = []
		render MobileService.findAllByPublished(true, [sort: "title", order: "asc"]).each {
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
		render result as JSON
	}
}
