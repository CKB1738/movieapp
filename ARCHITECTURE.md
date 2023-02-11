# COMP3350 G04 Iteration 1 Architecture

## Go4TV Architecture

### Packages

* Application
* Business(comp3350.go4tv.business)
    * Validator
* Objects(comp3350.go4tv.objects)
* Persistence(comp3350.go4tv.Persistence)
    * stubs
* Presentation(comp3350.go4tv.presentaion)
* Test(comp3350.go4tv(test))

### Application
Application package contains the Service class, which used to reference the persistance.

### Business
AccessUser class work togather with the Service class the interaction between the user interface and the stubs.

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

[![](https://mermaid.ink/img/pako:eNqdVU1v4jAQ_StWVtkTnNhTDisFEsJXoKLdVhD24DoDeDfYke3Qoqb_fQccShYuABLSzJt5if1mMvPhMJmC4zkrRfM1eQoWguDPdUkqN5QLonNgfMkZka9_gBlt437yS4P6bZ12Essth8rrJB252YAwle83mz_LHtWEkoxrQ-SyJJ0q9StU-hdIu3r4RY42uwyIT5Y8yzwFaUMbJf-C963ValV2842nZu39yN_rlPbtlM4tFBQtV6Dx6tRwKSwYJCO56gufGb7lZleJEiZTWKEa6pB5FuwmMSr_QFdwFogOqj8oiYc6j81tEc7QGb6n0PQ1gyd4Ny_UsPVX2ewNA3vDaBqG46tlCS1ppQDE1aTuPaToHtL8WhKps2Y3soJ9Zwp4IwUWpQz3HpaacFF2qzruoUgSI8sIzSH-BxeROZrxKRKQ76gu-mR2essEwXHVOP-7A3R7J7N_ShqeehKUxlYDwcBivUMbBdTQNtXHz7Zv--cMtcr0rDKzcDSavFxdhf6NLNf18zzjrPbxDJJHUFvOjsdx3XahuQBdjaFh4jOGXm0YxRVUH0njJMRZlj3TjKfUyGPqJOlyyNI6XD__0J5_MvXHUXj1reO7WIO7WOO7WJMbWE7D2YBC8VJcER_7pyxwYWRSLRwPTZyLC2chPjGNFkY-7gRzPKMKaDhFjppCwCkulo3jLWmmEYWUo9CxXTmHzfP5D6-uGzI?type=png)](https://mermaid.live/edit#pako:eNqdVU1v4jAQ_StWVtkTnNhTDisFEsJXoKLdVhD24DoDeDfYke3Qoqb_fQccShYuABLSzJt5if1mMvPhMJmC4zkrRfM1eQoWguDPdUkqN5QLonNgfMkZka9_gBlt437yS4P6bZ12Essth8rrJB252YAwle83mz_LHtWEkoxrQ-SyJJ0q9StU-hdIu3r4RY42uwyIT5Y8yzwFaUMbJf-C963ValV2842nZu39yN_rlPbtlM4tFBQtV6Dx6tRwKSwYJCO56gufGb7lZleJEiZTWKEa6pB5FuwmMSr_QFdwFogOqj8oiYc6j81tEc7QGb6n0PQ1gyd4Ny_UsPVX2ewNA3vDaBqG46tlCS1ppQDE1aTuPaToHtL8WhKps2Y3soJ9Zwp4IwUWpQz3HpaacFF2qzruoUgSI8sIzSH-BxeROZrxKRKQ76gu-mR2essEwXHVOP-7A3R7J7N_ShqeehKUxlYDwcBivUMbBdTQNtXHz7Zv--cMtcr0rDKzcDSavFxdhf6NLNf18zzjrPbxDJJHUFvOjsdx3XahuQBdjaFh4jOGXm0YxRVUH0njJMRZlj3TjKfUyGPqJOlyyNI6XD__0J5_MvXHUXj1reO7WIO7WOO7WJMbWE7D2YBC8VJcER_7pyxwYWRSLRwPTZyLC2chPjGNFkY-7gRzPKMKaDhFjppCwCkulo3jLWmmEYWUo9CxXTmHzfP5D6-uGzI)
