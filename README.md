# Connect to the Internet -Back End Part
* Customer back end application using springboot building RESTful Web Services that we can contact with using API and  front end applications.
* Customer back end plays the whole role starting from loading the database and run filtration on it based state of the phone number and country which is from.


 It leverages the following components :

* [Spring Framework](https://spring.io/projects/spring-framework)
* [Java util Regex](https://docs.oracle.com/javase/7/docs/api/java/util/regex/package-summary.html)

 
 ## Screenshots

![Screenshot 1](springboot-backend/screenshots/spring_app_run.JPG)
![Screenshot 2](springboot-backend/screenshots/running_1.JPG)
![Screenshot 3](springboot-backend/screenshots/running_2.JPG)





 
## How to boot up this application  
* go to the file SQLite.springboot-master and load the file on Inteliji IDE  or any prefered IDE .


https://github.com/AbdelrhmanSror/android-customer-api/blob/ba264c3debe9fbbb6351bad4c48f471bb0d316b2/SQLite.springboot-master/src/main/java/com/jumia/SQLite/springboot/SpringBootAndSqLiteApplication.java

* run the application

* if you are going to run the docker file map it to port 8090


# Connect to the Internet -Front End Part


## android Customer Api
Customer front end application that conects with back end spring boot application.
Customer is a simple demo app using ViewModel & LiveData with Retrofit, Glide and Moshi in Kotlin.

It leverages the following components from the Jetpack library:

* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
* [Data Binding](https://developer.android.com/topic/libraries/data-binding/) with binding adapters

## Screenshots

![Screenshot 1](screenshots/Screenshot_20210719-163310_Customers.jpg)
![Screenshot 2](screenshots/Screenshot_20210719-163315_Customers.jpg)
![Screenshot 3](screenshots/Screenshot_20210719-163322_Customers.jpg)
![Screenshot 4](screenshots/Screenshot_20210719-163327_Customers.jpg)
![Screenshot 5](screenshots/Screenshot_20210719-163334_Customers.jpg)
![Screenshot 6](screenshots/Screenshot_20210719-163338_Customers.jpg)
![Screenshot 7](screenshots/Screenshot_20210719-163405_Customers.jpg)
![Screenshot 8](screenshots/Screenshot_20210719-163413_Customers.jpg)
![Screenshot 9](screenshots/Screenshot_20210719-163416_Customers.jpg)
![Screenshot 10](screenshots/Screenshot_20210719-163421_Customers.jpg)
![Screenshot 11](screenshots/Screenshot_20210719-163424_Customers.jpg)





## How to boot up this application  
1- first run the application on android studio or any prefered IDE.


2- go to cmd and type ipconfig as follows.

  ![Screenshot 12](screenshots/cmd.JPG).
  
3- get the part related to iPV4 address.

  ![Screenshot 13](screenshots/ip.JPG).
  
4- go in the application to file customerServiceApi

   https://github.com/AbdelrhmanSror/android-customer-api/blob/568a2bd0f8a90977e4f47ff58de5425cd13e3296/app/src/main/java/com/example/android/customerspringbootandroid/network/CustomerApiService.kt.
   
   
5- paste the ip address that we got in step 3 from the cmd  into IP_ADDRESS variable .
   
   ![Screenshot 13](screenshots/ip_address_variable.JPG).
   
   
6- run the application.



## Report Issues
Notice any issues with a repository? Please file a github issue in the repository.
