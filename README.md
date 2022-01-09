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

 ### App Screenshots :
 

  <table align="center">
  <tr>
    <th>Starting Splash Screen</th>
    <th>User Mode</th>
    <th>Student Signup mode</th>
  </tr>
  <tr>
    <td><img src="https://user-images.githubusercontent.com/74124514/148682661-3df04f47-7508-4553-88c1-469129af2205.jpeg" alt="Splash Screen" style="width:250px;height:500px;"></td>
    <td><img src="https://user-images.githubusercontent.com/74124514/148585702-3ce64e9e-e10d-4981-a899-e2c067515748.jpeg" alt="Usermode" style="width:250px;height:500px;"></td>
    <td><img src="https://user-images.githubusercontent.com/74124514/148633927-a72cf42d-5ca1-4bae-a521-2beca3da9e86.jpeg" alt="studentsignup" style="width:250px;height:500px;"></td>
  </tr>

</table><br><br>

##  Student Mode:







  <table align="center">
  <tr>
    <th>Sign In</th>
    <th>Sign In 2</th>
    <th>Student Profile Picture upload</th>
  </tr>
  <tr>
    <td><img src="https://user-images.githubusercontent.com/74124514/148633991-1bcd5b59-10c1-412e-984c-f115de6c007f.jpeg" alt="News Display" style="width:250px;height:500px;"></td>
    <td><img src="https://user-images.githubusercontent.com/74124514/148633994-8452a4c7-b95e-4d10-b342-80ec96149d08.jpeg" alt="Saved News" style="width:250px;height:500px;"></td>
    <td><img src="https://user-images.githubusercontent.com/74124514/148634115-8c476ef0-2e12-4128-81ca-9226738a9a58.jpeg" alt="Image - news sharing" style="width:250px;height:500px;"></td>
  </tr>

</table><br><br>

   <table align="center">
  <tr>
    <th>Student Mode Announcement Screen</th>
    <th>Student Profile Screen</th>
    <th>Student Mode Announcement Info</th>
  </tr>
  <tr>
    <td><img src="https://user-images.githubusercontent.com/74124514/148587418-19b9859e-7e07-4dbe-a044-41efd0622aba.jpeg" alt="News Display" style="width:250px;height:500px;"></td>
    <td><img src="https://user-images.githubusercontent.com/74124514/148587439-30238aa7-32cc-486f-b299-8f6834dd0bc2.jpeg" alt="Saved News" style="width:250px;height:500px;"></td>
    <td><img src="https://user-images.githubusercontent.com/74124514/148587454-ddbe41fc-8e9b-4507-80a1-b51d75ca7c11.jpeg" alt="Image - news sharing" style="width:250px;height:500px;"></td>
  </tr>

</table><br><br>




 <table align="center">
  <tr>
    <th>Result Selection</th>
    <th>See Result</th>
  </tr>
  <tr>
    <td><img src="https://user-images.githubusercontent.com/74124514/148587797-a77b5fe3-82e2-489c-bfc1-27893cef445f.jpeg" alt="Splash Screen" style="width:250px;height:500px;"></td>
    <td><img src="https://user-images.githubusercontent.com/74124514/148587804-2e328452-f05c-4065-a16a-5616e8fdd55e.jpeg" alt="Usermode" style="width:250px;height:500px;"></td>
  </tr>

</table><br><br>


## Admin Mode:


  <table align="center">
  <tr>
    <th>Admin Mode authentication</th>
    <th>Announcements(Admin Mode) </th>
    <th>Make Announcement(Admin Mode)</th>
  </tr>
  <tr>
    <td><img src="https://user-images.githubusercontent.com/74124514/148634145-a10ecbb8-79db-45db-bce8-c3e4bf161cec.jpeg" alt="Splash Screen" style="width:250px;height:500px;"></td>
    <td><img src="https://user-images.githubusercontent.com/74124514/148588368-0c084e00-14d6-42f5-8fc4-d83325625004.jpeg" alt="Usermode" style="width:250px;height:500px;"></td>
    <td><img src="https://user-images.githubusercontent.com/74124514/148634150-d6b720ab-37a5-4cc6-b919-d91ad4a4ce6c.jpeg" alt="studentsignup" style="width:250px;height:500px;"></td>
  </tr>

</table><br><br>




 <table align="center">
  <tr>
    <th>Result Selection(Admin Mode)</th>
    <th>Write Result</th>
  </tr>
  <tr>
    <td><img src="https://user-images.githubusercontent.com/74124514/148588620-d06ea6a1-173e-4ce4-ad58-0337d31469a4.jpeg" alt="Splash Screen" style="width:250px;height:500px;"></td>
    <td><img src="https://user-images.githubusercontent.com/74124514/148588625-2b1faea6-4942-4cd0-977a-786f246f2497.jpeg" alt="Usermode" style="width:250px;height:500px;"></td>
  </tr>

</table><br><br>


#### APK link: [CollegeApp](https://drive.google.com/drive/folders/1CmKKBfYSPCvIuQ1fs2kl6CTv0nnUsrEN?usp=sharing)


#### Future Scope

Could be furthur more developed into a fully fledged college application which would be capable of carrying out transaction(Paying fees), Hosting classes online and much more. 

