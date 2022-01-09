# CollegeApp
Android Study Jams

# CollegeApp 


Is a android application which keeps the user(Student) notified, about the happenings in the campus and provides the user an online method for accessing few of the college resources .


### Problem Statement :


This app was developed regarding the fact that most of the students who are not present nearby beacause of the covid scenario could not access the bulletin board of the college due to which they always tend to miss some crucial opportunities .


### Proposed Solution :

This application provides the students of a particular university to signup/login in the application and see all the notices which are provided by the admins who are managing the data within the application. 


### Working :


As soon as user opens the application user is provided with an option to select in which mode the user wants to operate student mode or Admin mode.

 #### Student mode:
 This is the read only mode in which the user could not announce or write results but it does provide the functionality of reading the notices/announcements uploaded by admins.  Apart from all the functionalities student mode needs a email and a password in order to signup with the application. The application would send a mail to the email provided by the user, the mail would consist of a verification link when the user verifies himself by clicking on the link then the user is capable of logging in and could access the functionalities. 
 
#### Admin mode:
This mode allows the user(Admin) to write Results of a particular student identified by university roll number. This mode is also capable of making announcements which would be read in student mode as well as in admin mode.

#### Database Used:

The database used in the application is firebase which is a NoSQL database. Firebase provides us functionalities such as Authentication of users, Real-time database, firebase Storage and much more.

But in this project, I have used these three functionalities. Authentication for signup, Real-time database for storing data related to the user such as student result, email, link of profile pic apart from that real-time storage also store the announcement data. At last Firebase storage for storing the images related to announcements, and profiles of students and getting their download link to store in a real-time database.

## **Functionality & Concepts used**

This application has a simple yet interactive interface so that the students could easily interact with this application without any problems. Following are the concepts used in application to provide functionalities.

- `Constraint Layout` : Most of the activities in this application use constraint layout to arrange the UI elements easily without writing much code.
- `Recyclerview` :  For creating a list of all the announcements and presenting them to the user recycler view is used. 
- `Dhaval Image picker` : For selecting the images which the user decides as their profile pictures or as a part of making an announcement.
- `Firebase` : For storing user information, User Data and Authentication purpose.
- `Material Design` : For making this application more interactive or beautiful material design has been used in signup and sign-in options.
