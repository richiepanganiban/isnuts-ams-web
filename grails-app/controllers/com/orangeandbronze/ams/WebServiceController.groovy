package com.orangeandbronze.ams

import grails.converters.XML

class WebServiceController {

    def getMobileServices = {
		def result = []
		render MobileService.findAllByPublished(true).each {
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
			mobileServiceMap['keywordItems'] = keywordItems
			result << mobileServiceMap
		}
		render result as XML
	}
}
