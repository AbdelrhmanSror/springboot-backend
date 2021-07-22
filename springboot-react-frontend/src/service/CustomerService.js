import axios from 'axios'



const CUSTOMER_API_URL="http://localhost:8090/customer";
//suspend fun getFilteredCustomers(@Query("countryCode") countryCode: Int, @Query("state") state: Int): List<Customer>
//http://192.168.1.11:8090/customer/FilteredCustomers/?countryCode=237&state=0
class CustomerService{
    getAllCustomers(){
      return axios.get(CUSTOMER_API_URL+'/Customers', 
        { crossdomain: true }
         );
       
    }
    getFilteredCustomers(countryCode,state){
        return axios.get(CUSTOMER_API_URL+'/FilteredCustomers/?countryCode='+countryCode+'&state='+state,{ crossdomain: true });
 
     }
}
export default new CustomerService()
