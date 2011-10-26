package com.orangeandbronze.ams

class KeywordItem {
	
	static belongsTo = [mobileServiceInstance:MobileService]
	String label
	KeywordItemType itemType
	String literalValue
	
    static constraints = {
		label(blank:true, nullable:true, 
			validator: {
				val, obj ->
				if (obj.properties['itemType'] != KeywordItemType.SPACE && 
					obj.properties['itemType'] != KeywordItemType.LITERAL) {
					if (val == null || val.trim().length() == 0) {
						return ['blank']
					}
				}
			}
		)
		literalValue(blank:true, nullable:true, maxSize:50,
			validator: {
				val, obj ->
				if (obj.properties['itemType'] == KeywordItemType.LITERAL) {
					if (val == null || val.trim().length() == 0) {
						return ['blank']
					}
				}
			}
		)
    }
}
