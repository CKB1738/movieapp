# COMP3350 G04 Iteration 1 Architecture

## Go4TV Architecture

### Packages

* Application
* Business(comp3350.go4tv.business)
    * Validator
* Objects(comp3350.go4tv.objects)
* Persistence(comp3350.go4tv.Persistence)
    * stubs
    * HSQLDB
* Presentation(comp3350.go4tv.presentaion)
* Test(comp3350.go4tv(test))

### Application
Application package contains the Service class, which used to reference the persistance.

### Business
AccessUser class work togather with the Service class the interaction between the user interface and the stubs.

Validator package contains two class, which can validate the field of user input and the email of user input.

### Objects
Domain Specific objects, User class, Comment class and Movie class.

### Persistence
Currently, we are using a stub class to store the data(a List object), a relational database will be implemented in next iteration.

### Presentation
MainActivity: The first log in page user will see.

RegistrationActivity: Page for user sign up.

MainPageActivity: This is a temperary page, just to show the flow of the application after log in / sign up.

UserProfileActivity: This page shows user profile.

ResuableTextWatches: This class monitor the user input and warns user about the empty field.

### Test
This package contains the unit test of all method except the UI part.


### Go4TV Archetecture Flowchart

Domain Specific Objects: Red
Presentation Tier: Green
Logic Tire: Orange
Data Tier: Yellow

[![](https://mermaid.ink/img/pako:eNqdVUtv4jAQ_itWVuyJnthTDisFEt6BLrRb0bAHxx7AuyGObKcPlf73HbBbUrhAIlma-Wa-SeYRz5vHJAfP99aKFhtyFy5zgk-jQbjcUpETXQATK8GITP8CM9rag-Reg_pjlXYSyycBTuskHbndQm6cHtzc_Nz1qSaUZEIbIlc70nGun6ZdcIa0XfAzH21eMyABWYks8xXwpjZK_gP_W6vVcvLNs-Bm4_8oXqqU9vWUzjUULFqhQGPq1AiZWzBMxnI9yANmxJMwr64oUTKDNVZDHTxPjN0kxsrf0jWcGHqHqt8qiR91anu0TThBF_ieUtM0gzt4MQ_UsM1n22yGoc2wN4uiycVliSxprQDyi0ndOqReHdLjpSRSZS2uZIX7yczhmZTYlF2017DVROS7ruvjHupJYuSuh-IIz_DM8ohifLSE5DtWF3WyOL5liuDEDc5XdYhqHw-lVt_LaXq0DfAwZvW9zPkxzOg4taA0DiPkDFyYw6CF1NA21R8_9sBO2AlK6cF3bsrUIWl6QPrzX-Ow7TDGLLnixnkSFwh98bOd6NtOLKLxePpwcdcHtViU1qKlaS0aY7VonF9JazSCosgEq1xEw2QO6kmwj8Y1Gu1Sixy0u9JHScAYapWLPXZQ9XqfJBHuhew3zQSnRn64TpOugIxX4WoCI_v901kw6UUXpx3XYg1rsSa1WNMrWF7T24LC4nFct2_7KEtcvplUS89HEXfM0mta2GxgCxbmsKJlZpbeMn_HCLQ0cv6aM883qoSmVxZYbggFxf299fwVzTSiwAX2ILab_bDg3_8Do_KO1g?type=png)](https://mermaid.live/edit#pako:eNqdVUtv4jAQ_itWVuyJnthTDisFEt6BLrRb0bAHxx7AuyGObKcPlf73HbBbUrhAIlma-Wa-SeYRz5vHJAfP99aKFhtyFy5zgk-jQbjcUpETXQATK8GITP8CM9rag-Reg_pjlXYSyycBTuskHbndQm6cHtzc_Nz1qSaUZEIbIlc70nGun6ZdcIa0XfAzH21eMyABWYks8xXwpjZK_gP_W6vVcvLNs-Bm4_8oXqqU9vWUzjUULFqhQGPq1AiZWzBMxnI9yANmxJMwr64oUTKDNVZDHTxPjN0kxsrf0jWcGHqHqt8qiR91anu0TThBF_ieUtM0gzt4MQ_UsM1n22yGoc2wN4uiycVliSxprQDyi0ndOqReHdLjpSRSZS2uZIX7yczhmZTYlF2017DVROS7ruvjHupJYuSuh-IIz_DM8ohifLSE5DtWF3WyOL5liuDEDc5XdYhqHw-lVt_LaXq0DfAwZvW9zPkxzOg4taA0DiPkDFyYw6CF1NA21R8_9sBO2AlK6cF3bsrUIWl6QPrzX-Ow7TDGLLnixnkSFwh98bOd6NtOLKLxePpwcdcHtViU1qKlaS0aY7VonF9JazSCosgEq1xEw2QO6kmwj8Y1Gu1Sixy0u9JHScAYapWLPXZQ9XqfJBHuhew3zQSnRn64TpOugIxX4WoCI_v901kw6UUXpx3XYg1rsSa1WNMrWF7T24LC4nFct2_7KEtcvplUS89HEXfM0mta2GxgCxbmsKJlZpbeMn_HCLQ0cv6aM883qoSmVxZYbggFxf299fwVzTSiwAX2ILab_bDg3_8Do_KO1g)
