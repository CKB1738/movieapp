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
AccessUser class work togather with the Service class the interaction between the user interface and the database.

AccessMovie class work togather with the Service class, handle the interaction between the movie interface and the database.

AccessFavouriteMovie class work togather with the Service class, handle the interaction between the movie interface and the database.

Validator package contains two class, which can validate the field of user input and the email of user input.

### Objects
Domain Specific objects, User class, Comment class and Movie class.

### Persistence
We are using the HSAQLDB as our database, which contains 3 tables, USER table, MOVIE table, and favourite list Table.

### Presentation
MainActivity: The first log in page user will see.

RegistrationActivity: Page for user sign up.

MainPageActivity: This is a temperary page, just to show the flow of the application after log in / sign up.

UserProfileActivity: This page shows user profile.

ResuableTextWatches: This class monitor the user input and warns user about the empty field.

FavouriteMovieActivity: This is a page that shows a user's favourite movies list. It can be accessed from UserProfile.

MovieDetailActivity: This is the page shows the detail of a movie, it contains a button to add this movie to user's favourite movie list.

Adaptor and mMvieViewHolder: These are helper class to the recyclerView of the favourite movie list.

### Test
This package contains the unit test of all method except the UI part.


### Go4TV Archetecture Flowchart

Domain Specific Objects: Red
Presentation Tier: Green
Logic Tire: Orange
Data Tier: Yellow


[![](https://mermaid.ink/img/pako:eNqdVktz2jAQ_isad-iJnNITh84YbN6vhjSEmB5kaQG1xvLYMsET8t-7RiIGcwHj0Yz22_1WYh-SPiwmOVgNax3TaEOenWVI8FerES63VIQkiYCJlWBE-n-BqUTrbe93AvEfLTS9kdwJMFLLa8ntFkJlZPvh4eehSxNCSSASReTqQFrG9Et1sK-QpnF-ZZOoLABik5UIgkYMvJ6oWP6DxrfHx0czf3gXXG0aP6L9OaV5P6V1DwWDFsWQ4F-nSshQg443lOteaDMldkJlJiiu9wRrjEZ8tCwp294IIz-laygpOseoT2OJmyrr3nQSSugC10kT6gfwDHs1p4ptvtL26rXpTqaxUDDErZSYc2-b-3NAURGUdPu9Vr4IeO_KgKNLzNKrVmaZZ3MaqQtQR3O_1-FcxwDhzTnIsiosR5M6T647vpnkVlmpXYXUqUJ6u5VEzlmLSqzXSqz5nawOlsi8mJpqcfKeD-GdpFjuBzeXsImICA9t0yE51JFEyUNOG-DoX2necDoqNA75jvlFmSyKVSYIjk1LXop9FLs4KNVyPvf9QtfDwZiW8znnhZtBcR5AnGBvQcjAuDm2sEMVbdLkdGT2dO-WUEqPtjOV-gbx_SPSnf0aOk2DMabJZ2aca-jCDqBo92utzl5XZ2_hDoeT-c1V2avEorQSzfcr0RirROO8Eg3gTlpeQACnqrGjKBDs7A7pezOId4KdKqNWa6aJCCExt_HAsxlD6exOHhno_GYeey5e6cELDQSnSp5MJ15bQMDL8NR4uKya092BG54WvTUvn_RTHYDJkz3uuDfHbVCJNarE6ldijSuxJnewTp9Vt7YQY744Ps4-cm9LfKoFMl5aDZzii2Rp1TWsNrAFDXNY0TRQS2sZfqIHmio5y0JmNVScQt1KI8wwOILia29rNVY0SBAFLjDtI_0OPD4HP_8D6itHsw?type=png)](https://mermaid.live/edit#pako:eNqdVktz2jAQ_isad-iJnNITh84YbN6vhjSEmB5kaQG1xvLYMsET8t-7RiIGcwHj0Yz22_1WYh-SPiwmOVgNax3TaEOenWVI8FerES63VIQkiYCJlWBE-n-BqUTrbe93AvEfLTS9kdwJMFLLa8ntFkJlZPvh4eehSxNCSSASReTqQFrG9Et1sK-QpnF-ZZOoLABik5UIgkYMvJ6oWP6DxrfHx0czf3gXXG0aP6L9OaV5P6V1DwWDFsWQ4F-nSshQg443lOteaDMldkJlJiiu9wRrjEZ8tCwp294IIz-laygpOseoT2OJmyrr3nQSSugC10kT6gfwDHs1p4ptvtL26rXpTqaxUDDErZSYc2-b-3NAURGUdPu9Vr4IeO_KgKNLzNKrVmaZZ3MaqQtQR3O_1-FcxwDhzTnIsiosR5M6T647vpnkVlmpXYXUqUJ6u5VEzlmLSqzXSqz5nawOlsi8mJpqcfKeD-GdpFjuBzeXsImICA9t0yE51JFEyUNOG-DoX2necDoqNA75jvlFmSyKVSYIjk1LXop9FLs4KNVyPvf9QtfDwZiW8znnhZtBcR5AnGBvQcjAuDm2sEMVbdLkdGT2dO-WUEqPtjOV-gbx_SPSnf0aOk2DMabJZ2aca-jCDqBo92utzl5XZ2_hDoeT-c1V2avEorQSzfcr0RirROO8Eg3gTlpeQACnqrGjKBDs7A7pezOId4KdKqNWa6aJCCExt_HAsxlD6exOHhno_GYeey5e6cELDQSnSp5MJ15bQMDL8NR4uKya092BG54WvTUvn_RTHYDJkz3uuDfHbVCJNarE6ldijSuxJnewTp9Vt7YQY744Ps4-cm9LfKoFMl5aDZzii2Rp1TWsNrAFDXNY0TRQS2sZfqIHmio5y0JmNVScQt1KI8wwOILia29rNVY0SBAFLjDtI_0OPD4HP_8D6itHsw)
