Due to limited time I havent got to figure out the issue regarding the pagination.
I believe it is due to springboot-thymeleaf stuff that i'm not quite familiar with.
But the pagination will work if following steps is followed.

At the RecordController.java:
- Please enable annotation @Controller to see the pagination
- Disable/comment the @RestController
- restart the app
- open in browser http://localhost:8080/