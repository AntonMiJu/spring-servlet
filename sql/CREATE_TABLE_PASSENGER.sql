CREATE TABLE PASSENGERS(
    ID NUMBER,
    CONSTRAINT PASSENGER_PK PRIMARY KEY (ID),
    LAST_NAME NVARCHAR2(30),
    NATIONALITY NVARCHAR2(20),
    DATE_BIRTH DATE,
    PASSPORT_CODE NVARCHAR2(15)
);