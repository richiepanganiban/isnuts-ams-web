package com.orangeandbronze.ams

class MobileServiceCategory {
	String name, description
	
	static belongsTo = MobileService
	static hasMany = [services : MobileService]
	
	static constraints = {
		name(blank:false, nullable:false, unique:true, maxSize:30)
		description(blank:true, nullable:true, maxSize:500)
	}
			
}
