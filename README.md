# clubin
This is the real file to be executed for CS319 Project DEMO.

FOLLOWING CODE IS A GUIDE TO CLUBIN PROJECT

-------------------------------------------------
************CREATING STUDENT***************
POST: http://localhost:9090/addStudent
{
    "id": 100,
    "name": "student1",
    "surname": "surname1",
    "password": "pass",
    "email": "studen1@g.com",
    "gePoints" : 50,
    "takingGeCourse" : true,
    "registeredClubs" : [],
    "role" : "STUDENT"
}
--------------------------------------------------
************CREATING STUDENT***************
POST: http://localhost:9090/addStudent
{
    "id": 101,
    "name": "student1",
    "surname": "surname1",
    "password": "pass",
    "email": "studen1@g.com",
    "gePoints" : 53,
    "takingGeCourse" : true,
    "role" : "STUDENT"
}
-----------------------------------------------------
************CREATING CLUB***************
POST: http://localhost:9090/addClub
{
    "id": 1,
    "name": "OR",
    "totalMemberCount": 0,
    "clubMembers": [],
    "clubEvents": []
}
----------------------------------------------------------
************CREATING CLUB***************
POST: http://localhost:9090/addClub
{
    "id": 2,
    "name": "MEC",
    "totalMemberCount": 0,
    "clubMembers": [],
    "clubEvents": []
}

----------------------------------------------------------
************ADDING STUDENTS TO CLUBS*************
PUT: http://localhost:9090/joinToClub/club_id=1/student_id=100
PUT: http://localhost:9090/joinToClub/club_id=1/student_id=101
PUT: http://localhost:9090/joinToClub/club_id=2/student_id=100
PUT: http://localhost:9090/joinToClub/club_id=2/student_id=101
-------------------------------------------------------------
*************CREATING EVENTS*******************
POST: http://localhost:9090/createEvent
{
    "id": 1,
    "name": "event1",
    "date": "",
    "startingTime": "14:00",
    "endingTime": "16:00",
    "gePoint" : 10,
    "capacity" : 50,
    "isPassed" : false,
    "description" : "COME AND JOIN EVENT1!!!",
    "isOnline" : false,
    "budget" : 100
}

POST: http://localhost:9090/createEvent

{
    "id": 2,
    "name": "event2",
    "date": "",
    "startingTime": "19:00",
    "endingTime": "20:00",
    "gePoint" : 15,
    "capacity" : 10,
    "isPassed" : false,
    "description" : "COME AND JOIN EVENT2!!!",
    "isOnline" : false,
    "budget" : 10
}
------------------------------------------------------------------------
***************ASSIGNING EVENTS TO THE CLUBS************************
***************THIS ALSO AUTOGENERATES NOTIFICATION OF THE EVENT****
PUT: http://localhost:9090/assignExistingEventToClub/club_id=1/event_id=1
PUT: http://localhost:9090/assignExistingEventToClub/club_id=2/event_id=2
--------------------------------------------------------------------------
***************REGISTERING TO EVENT AS A STUDENT**********************
PUT: http://localhost:9090/registerToEvent/student_id=100/event_id=1
PUT: http://localhost:9090/registerToEvent/student_id=100/event_id=2
PUT: http://localhost:9090/registerToEvent/student_id=101/event_id=1
PUT: http://localhost:9090/registerToEvent/student_id=100/event_id=2


-------------------------------------------------------------------------
Example Program -------------------------------------------------
Process of creating a club in the Clubin.
As we introduced in our diagram;
creating a club is not easy and requires 
verifications of multiple sources in the system. 
The process looks like this;
-Any student account can create CreateClubForm 
-StudentActivityCenter and DeanOffice receive the create form request
-Firstly studentActivity center accepts the request if they want or they reject.
-After first approval comes from student activity center, dean office can start to evaluate form.
-If dean office also approves the form, new club is created with the given information in the form.
------DeanOffice Kaydetme-----
localhost:9090/addDeanOffice 
POST
{
    "id": 666,
    "name": "dean",
    "surname": "office",
    "password": "dean1234",
    "email": "deanoffice@gmail.com",
    "createClubForms": [],
    "createEventForms": []
}

addStudentActivityCenter-------------
9090/addStudentActivityCenter
POST
{
    "id": 999,
    "name": "sac",
    "surname": "center",
    "password": "123456",
    "email": "sac@gmail.com",
    "createClubForms": [],
    "createEventForms": []
}


addStudentToCreateForm--------
9090/addStudent
POST
{
    "id": 200,
    "name": "student1",
    "surname": "surname1",
    "password": "pass",
    "email": "studen1@g.com",
    "gePoints" : 50,
    "takingGeCourse" : true,
    "registeredClubs" : []
}
createClubForm-------------
9090/createClubFormStudent
POST
{
    "createClubForm_id" : 1,
    "deanOffice_id" : 666,
    "studentActivityCenter_id": 999,
    "student_id" : 200,
    "clubName" : "Bilkent Bilardo",
    "club_id" : 1000,
    "isSuccessfull" : false,
    "description" : "Snooker team in bilkent", 
    "contactInfo" : "SA Building"
}


createClubForm---->>StudentActivityCenter

sac answer the waiting forms ---------
9090/sac/answerCreateClubForm
PUT
{
    "createClubForm_id" : 1,
    "deanOffice_id" : 666,
    "studentActivityCenter_id": 999,
    "student_id" : 200,
    "clubName" : "Bilkent Bilardo",
    "club_id" : 1000,
    "isSuccessfull" : false,
    "description" : "Snooker team in bilkent", 
    "contactInfo" : "SA Building"
}

sac --->>>> deanOffice
9090/answerCreateClubForm
POST
{
    "createClubForm_id" : 1,
    "deanOffice_id" : 666,
    "studentActivityCenter_id": 999,
    "student_id" : 200,
    "clubName" : "Bilkent Bilardo",
    "club_id" : 1000,
    "isSuccessfull" = false,
    "description" : "Snooker team in bilkent", 
    "contactInfo" : "SA Building"
}

showAllClubsToSeeNewCreatedClubs
9090/allClubs
-----------------------------------------------------------




