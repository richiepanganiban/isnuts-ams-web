package com.orangeandbronze.ams

class KeywordItem {
	
	static belongsTo = [mobileServiceInstance:MobileService]
	String label
	KeywordItemType itemType
	String literalValue
	
    static constraints = {
		label(blank:false, nullable:false, maxSize:50)
		literalValue(blank:true, nullable:true, maxSize:50,
			validator: {
				if (itemType == KeywordItemType.LITERAL) {
					if (literalValue == null || literalValue.trim().length() == 0) {
						return ['blank']
					}
				}
			}
		)
    }
}
