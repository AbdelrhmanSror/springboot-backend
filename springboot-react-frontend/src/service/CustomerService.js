import axios from 'axios'



const CUSTOMER_API_URL="http://localhost:8090/customer";
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
