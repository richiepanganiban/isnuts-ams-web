package com.orangeandbronze.ams

class MobileService {
	
	boolean activePromo = true
	boolean published = false
	MobileServiceType serviceType
	
	String title
	String description

	String serviceNumber
	boolean appendMobileToServiceNumber = false
	static hasMany = [keywordItems:KeywordItem, categories:MobileServiceCategory]
	
    static constraints = {
		serviceNumber(blank:false, nullable:false, maxSize:20)
		title(blank:false, nullable:false, maxSize:20)
		description(blank:false, nullable:false, maxSize:500)
    }
}
