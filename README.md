# Introduction:



## Hostel Management Information System


This project will provide a GUI based application whose main goal is to keep track of students/employee/workers and the hostel details of an Organisation.

The product is viable for every organization irrespective of its size or structure. This application helps in cutting down the efforts to maintain ledgers or books and therefore reducing the cost of manpower and stationery. The only requirements are:-

1. 1)A Java compatible OS
2. 2)Local MySQL server
3. 3)Basic hardware requirements needed to run any computer
4. 4)JRE Version 1.8+
5. 5)JDK Version 7+



**About The Application**

The application is an executable JAR. There is a package named **hostelInformationManagementSystem** which contains the following classes:

1. 1)java
2. 2)java
3. 3)java
4. 4)java
5. 5)java
6. 6)java

The entire application is built on Java Swing with a MySQL connection for the User Database. Every class serves a different purpose and helps in adding better functionality to the application program. Using different classes we can divide the application into sub-programs which is easier to maintain and code for. The classes used in this application link with each other to provide a seamless interaction between the application and the user.

## Components Description

The following components are used in this project:

## 1. **JFrame** 
The javax.swing.JFrame class is a type of container which inherits the java.awt.Frame class. JFrame works like the main window where components like labels, buttons, textfields are added to create a GUI. Unlike Frame, JFrame has the option to hide or close the window with the help of setDefaultCloseOperation(int) method.

## 2. **JTextField** 
The object of a JTextField class is a text component that allows the editing of a single line text. It inherits JTextComponent class.

## 3. **JPasswordField** 
PasswordField is a part of javax.swing package. The class JPasswordField is a component that allows editing of a single line of text where the view indicates that something was typed by does not show the actual characters. JPasswordField inherits the JTextField class in javax.swing package.

## 4. **JButton**
The JButton class is used to create a labeled button that has platform independent implementation. The application result in some action when the button is pushed. It inherits AbstractButton class.

## 5. **JRadioButton**
We use the JRadioButton class to create a radio button. Radio button is use to select one option from multiple options. It is used in filling forms, online objective papers and quiz. We add radio buttons in a ButtonGroup so that we can select only one radio button at a time. We use &quot;ButtonGroup&quot; class to create a ButtonGroup and add radio button in a group.

## 6. **JLabel**
JLabel is a class of java Swing . JLabel is used to display a short string or an image icon. JLabel can display text, image or both . JLabel is only a display of text or image and it cannot get focus . JLabel is inactive to input events such a mouse focus or keyboard focus. By default labels are vertically centered but the user can change the alignment of label.

## 7. **JOptionPane**
The class JOptionPane is a component which provides standard methods to pop up a standard dialog box for a value or informs the user of something.

## 8. **JTable**
The JTable class is a part of Java Swing Package and is generally used to display or edit two-dimensional data that is having both rows and columns. It is similar to a spreadsheet. This arranges data in a tabular form.

## Module Description

The following modules are used in the project:

1) **Connect.java**

**The connect.java class is used to connect to the external MySQL Database which is running on the local MySQL server. The class can be edited to add custom database server address and ensure proper connectivity. Users can call the connect function to create a connection of the desired server and the database name.**

**The connect function has a String parameter which takes the Database name under the present server as an input and returns a connection instance of the database on the server.**

2) **LoginPage.java**

**The loginPage.java is used to log in to the application using a username and password which is already stored in a database. The class validates the login by connecting to the userlist database and throws an exception if any invalid login is encountered. On successful login the class disposes and displays a Login Successful message for the user.**

3) **Admin.java**

**The admin.java class provides options for the user to either work with the student or hostel databases. If the user clicks the student button, the StudentRecord class in invoked. On the other hand, if the Hostel Record button is selected, the HostelRecord class is invoked and further usage can be done in their respective windows. This window however remains open throughout the usage of the application and only closes when the user closes this window explicitly.**

4) **StudentRecord.java**

**The StudentRecord.java class provides with an interface which allows us to either search for an existing student or add a new student record to the database. The existing student module opens up an InputBox which allows us to search for a particular student or ALL students in general. The user can enter the student name without having to match the existing student record as it will automatically remove all case sensitivity and even search names/ ID of a student.**

**The user can enter:**

a) **ALL – for displaying all student records**
b)**Specific Name – for displaying student(s) record with the entered name**
c) **ID – for displaying student record based on ID which is unique**

5) **addToDB.java**

**The addToDB.java class displays a form which helps a user to enter the details for a student. The user can enter students&#39; enrollment no. , Name, Phone, Address, Gender and Hostel ID. Any entry that doesn&#39;t match the preferred data type or pattern throws an error which is displayed to the user as an invalid entry. The user can then make amendments to the record and add it successfully.**

6) **HostelSearch.java**

**The HostelSearch.java class helps us to search Students in a particular hostel or the user can view the details of the Hostel, like the Hostel ID, Hostel Name, Warden, Fees.**

**Sample Input Output of the Project :**



1) **LoginPage.java**

  ![Login Page](/Screenshots/LoginPage.JPG)

  -**Fig1.0: Login Page**

  ![Login Page](/Screenshots/LoginInvalid.JPG)

  -**Fig 1.1: Login Invalid Error**


  ![Login Page](/Screenshots/LoginSuccessful.JPG)


  -**Fig 1.2: Login Successful Message**

2) **Admin.java**

  ![Admin Page](/Screenshots/Admin.JPG)

  -**Fig 2: Admin Panel**

3) **StudentRecord.java**

  ![Student Page](/Screenshots/StudentRecord.JPG)

  -**Fig 3.0: Student Record Selection Window**

  ![Student Page](/Screenshots/StudentRecord_Entry.JPG)

  -**Fig 3.1: Search Records for Existing Student**

  ![Student Page](/Screenshots/StudentRecord_ALL.JPG)

  -**Fig 3.2: Search result for 'ALL' student search**

  ![Student Page](/Screenshots/StudentRecord_Single.JPG)

  -**Fig  3.3: Search result for particular name/ID search**

  ![Student Page](/Screenshots/StudentRecord_error.JPG)

  -**Fig 3.4: Search result when entered student name/id doesn't exist**

4) **addToDB.java**

  ![AddtoDB Page](/Screenshots/addToDB.JPG)

  -**Fig 4.1: Form for adding student record**

  ![AddtoDB Page](/Screenshots/addToDB_success.JPG)

  -**Fig 4.2: Confirmation for successful entry**

  ![AddtoDB Page](/Screenshots/addToDB_validate_2.JPG)

  -**Fig 4.3: Message for error during data entry**

  ![AddtoDB Page](/Screenshots/addToDB_validate_1.JPG)

  -**Fig 4.4: Message for selecting gender if missed**

5) **HostelSearch.java**

  ![Hostel Page](/Screenshots/HostelSearch.JPG)

  -**Fig 5.0: Hostel Record Searching Window**

  ![Hostel Page](/Screenshots/HostelSearch_error.JPG)

  -**Fig 5.1: Message for selecting either of the two options if missed**


  ![Hostel Page](/Screenshots/HostelSearch_hostel.JPG)

  -**Fig 5.2: Search result for Hostel Information**
   
   ![Hostel Page](/Screenshots/HostelSearch_Student.JPG)
  
  -**Fig 5.3: Search result for students in a hostel**
