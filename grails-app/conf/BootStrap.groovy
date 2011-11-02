import com.orangeandbronze.ams.MobileService
import com.orangeandbronze.ams.MobileServiceType
import com.orangeandbronze.ams.KeywordItem
import com.orangeandbronze.ams.KeywordItemType

class BootStrap {

    def init = { servletContext ->
		def service, keyword
		
		// Balance Inquiry
		service = new MobileService(published:true, serviceType:MobileServiceType.SMS,
			title:'Balance Inquiry', description:'Inquire your balance.  Cost: Free', serviceNumber:'222').save(flush:true)
		keyword = new KeywordItem(mobileServiceInstance:service, itemType:KeywordItemType.LITERAL, literalValue:'BAL').save(flush:true)

		// Pasaload
		service = new MobileService(published:true, serviceType:MobileServiceType.SMS,
			title:'Pasa Load', description:'Share load to family and friends.  Cost: P1 per transaction', serviceNumber:'2', appendMobileToServiceNumber:true).save(flush:true)
		keyword = new KeywordItem(mobileServiceInstance:service, itemType:KeywordItemType.USER_INPUT, label:'Amount').save(flush:true)

		// Super Sakto Call
		service = new MobileService(published:true, serviceType:MobileServiceType.CALL,
			title:'Super Sakto Calls', description:'Call your friends on Globe and TM for only P0.15 per second!', serviceNumber:'232', appendMobileToServiceNumber:true).save(flush:true)

		// Tawag 236
		service = new MobileService(published:true, serviceType:MobileServiceType.CALL,
			title:'TAWAG 236 ', description:'20 minutes of chika for only 20 pesos!', serviceNumber:'236', appendMobileToServiceNumber:true).save(flush:true)

		// Duo
		service = new MobileService(published:true, serviceType:MobileServiceType.SMS,
			title:'DUO', description:'Unlimited calls to Globe Landlines and selected landlines for only P450/30days', serviceNumber:'8888').save(flush:true)
		keyword = new KeywordItem(mobileServiceInstance:service, itemType:KeywordItemType.LITERAL, literalValue:'DUO').save(flush:true)
		keyword = new KeywordItem(mobileServiceInstance:service, itemType:KeywordItemType.SPACE).save(flush:true)
		keyword = new KeywordItem(mobileServiceInstance:service, itemType:KeywordItemType.USER_INPUT, label:'Area').save(flush:true)
		keyword = new KeywordItem(mobileServiceInstance:service, itemType:KeywordItemType.SPACE).save(flush:true)
		keyword = new KeywordItem(mobileServiceInstance:service, itemType:KeywordItemType.LITERAL, literalValue:'450').save(flush:true)
	
		// Super Duo
		service = new MobileService(published:true, serviceType:MobileServiceType.SMS,
			title:'Super DUO', description:'Unlimited calls to Globe/TM, Globe Landlines and selected landlines for only P599/30days.', serviceNumber:'8888').save(flush:true)
		keyword = new KeywordItem(mobileServiceInstance:service, itemType:KeywordItemType.LITERAL, literalValue:'SUPERDUO').save(flush:true)
		keyword = new KeywordItem(mobileServiceInstance:service, itemType:KeywordItemType.SPACE).save(flush:true)
		keyword = new KeywordItem(mobileServiceInstance:service, itemType:KeywordItemType.USER_INPUT, label:'Area').save(flush:true)
		keyword = new KeywordItem(mobileServiceInstance:service, itemType:KeywordItemType.SPACE).save(flush:true)
		keyword = new KeywordItem(mobileServiceInstance:service, itemType:KeywordItemType.LITERAL, literalValue:'599').save(flush:true)
    }
    def destroy = {
    }
}
