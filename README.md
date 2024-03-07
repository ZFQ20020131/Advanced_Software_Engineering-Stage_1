## F21AS: Advanced Sorftware Engineering

### Coursework 2024 - A simulation of a simple airport check-in system.

---

#### Group Members:

* Fuquan Zhang
* Shuchen Sun
* Yuyao Wang
* Wentian Wang
* Muduo Xu

---
#### How to run the code:

- Download repository as ZIP
- Run CheckInCounter.java
- After running the program, follow the prompts on the interface to input the information from the .csv file. This will complete the check-in process and generate a summary report.
---
#### Core Functionality
1.After the first window pops up, enter any reference code from a .csv file. 

2.If correct, a second window will appear, prompting you to enter the passenger's last name from the .csv file. If the input matches, it will check whether the passenger has checked in. 

3.If not checked in, a third window will pop up, where you can input the volume and weight of the passenger's luggage. Here, you can calculate any additional fees if the luggage is overweight. 

4.After entering the details, click 'check in,' and a fourth window will appear. 

5.In the fourth window, click 'summary' to generate a report summarizing whether the passenger data for each flight meets the requirements.

Note: Due to the limited functionality of this system, please check in all passengers for the same flight at once after running the code. If checked in separately, the final summary calculation may be inaccurate.And we assume that each passenger can have multiple pieces of luggage.You just need to input the luggage information multiple times during the input process.

---
#### Tasks Distribution:

* Fuquan:
    - [x] Implementation of Class CheckinCounter
    - [x] Implementation of Class Passenger
    - [x] Modified the GUI class and the CheckInCounter class, and enhanced the functionality for generating the report
* Shuchen:
    - [x] Implementation of Class Name
    - [x] Implementation of Class ticket
* Yuyao:
    - [x] Implementation of Class CheckinCounterTest
    - [x] Implementation of BookingDetails
    - [x] Implementation of FlightDetails
* Wentian:
    - [x] Implementation of Class flight
    - [x] Debugging the code
* Muduo:
    - [x] Implementation of Class GUI
    - [x] Debugging the code
