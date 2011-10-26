import com.orangeandbronze.ams.MobileService
import com.orangeandbronze.ams.MobileServiceType
import com.orangeandbronze.ams.KeywordItem
import com.orangeandbronze.ams.KeywordItemType

class BootStrap {

    def init = { servletContext ->
		// Balance Inquiry
		def service = new MobileService(published:true, serviceType:MobileServiceType.SMS,
			title:'Balance Inquiry', description:'Inquire your balance.  Cost: Free', serviceNumber:'222').save(flush:true)
		def keyword = new KeywordItem(mobileServiceInstance:service, itemType:KeywordItemType.LITERAL, literalValue:'BAL').save(flush:true)
    }
    def destroy = {
    }
}
