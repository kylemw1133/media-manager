--
-- File generated with SQLiteStudio v3.3.3 on Thu Mar 31 22:09:46 2022
--
-- Text encoding used: UTF-8
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: ACTOR
CREATE TABLE ACTOR (
    Actor_ID INTEGER      PRIMARY KEY
                          UNIQUE
                          NOT NULL,
    Name     VARCHAR (50) 
);

INSERT INTO ACTOR (
                      Actor_ID,
                      Name
                  )
                  VALUES (
                      1,
                      'Joseph'
                  );

INSERT INTO ACTOR (
                      Actor_ID,
                      Name
                  )
                  VALUES (
                      2,
                      'David'
                  );

INSERT INTO ACTOR (
                      Actor_ID,
                      Name
                  )
                  VALUES (
                      3,
                      'Wyatt'
                  );

INSERT INTO ACTOR (
                      Actor_ID,
                      Name
                  )
                  VALUES (
                      4,
                      'Matthew'
                  );

INSERT INTO ACTOR (
                      Actor_ID,
                      Name
                  )
                  VALUES (
                      5,
                      'Luke'
                  );

INSERT INTO ACTOR (
                      Actor_ID,
                      Name
                  )
                  VALUES (
                      6,
                      'Carter'
                  );

INSERT INTO ACTOR (
                      Actor_ID,
                      Name
                  )
                  VALUES (
                      7,
                      'Julian'
                  );

INSERT INTO ACTOR (
                      Actor_ID,
                      Name
                  )
                  VALUES (
                      8,
                      'Grayson'
                  );

INSERT INTO ACTOR (
                      Actor_ID,
                      Name
                  )
                  VALUES (
                      9,
                      'Leo'
                  );

INSERT INTO ACTOR (
                      Actor_ID,
                      Name
                  )
                  VALUES (
                      10,
                      'Jayden'
                  );

INSERT INTO ACTOR (
                      Actor_ID,
                      Name
                  )
                  VALUES (
                      11,
                      'Gabriel'
                  );

INSERT INTO ACTOR (
                      Actor_ID,
                      Name
                  )
                  VALUES (
                      12,
                      'Isaac'
                  );

INSERT INTO ACTOR (
                      Actor_ID,
                      Name
                  )
                  VALUES (
                      13,
                      'Lincoln'
                  );

INSERT INTO ACTOR (
                      Actor_ID,
                      Name
                  )
                  VALUES (
                      14,
                      'Hudson'
                  );

INSERT INTO ACTOR (
                      Actor_ID,
                      Name
                  )
                  VALUES (
                      15,
                      'Anthony'
                  );

INSERT INTO ACTOR (
                      Actor_ID,
                      Name
                  )
                  VALUES (
                      16,
                      'Ezra'
                  );

INSERT INTO ACTOR (
                      Actor_ID,
                      Name
                  )
                  VALUES (
                      17,
                      'Thomas'
                  );

INSERT INTO ACTOR (
                      Actor_ID,
                      Name
                  )
                  VALUES (
                      18,
                      'Charles'
                  );

INSERT INTO ACTOR (
                      Actor_ID,
                      Name
                  )
                  VALUES (
                      19,
                      'Christopher'
                  );

INSERT INTO ACTOR (
                      Actor_ID,
                      Name
                  )
                  VALUES (
                      20,
                      'Caleb'
                  );


-- Table: ALBUM
CREATE TABLE ALBUM (
    Inventory_ID INTEGER      REFERENCES INVENTORY_ITEM (Inventory_ID) ON DELETE CASCADE
                              PRIMARY KEY
                              NOT NULL,
    Name         VARCHAR (50),
    Length       INTEGER,
    Year         INTEGER
);

INSERT INTO ALBUM (
                      Inventory_ID,
                      Name,
                      Length,
                      Year
                  )
                  VALUES (
                      1,
                      'Album1',
                      60,
                      2000
                  );

INSERT INTO ALBUM (
                      Inventory_ID,
                      Name,
                      Length,
                      Year
                  )
                  VALUES (
                      2,
                      'Album2',
                      61,
                      2001
                  );

INSERT INTO ALBUM (
                      Inventory_ID,
                      Name,
                      Length,
                      Year
                  )
                  VALUES (
                      3,
                      'Album3',
                      62,
                      2002
                  );

INSERT INTO ALBUM (
                      Inventory_ID,
                      Name,
                      Length,
                      Year
                  )
                  VALUES (
                      4,
                      'Album4',
                      63,
                      2003
                  );

INSERT INTO ALBUM (
                      Inventory_ID,
                      Name,
                      Length,
                      Year
                  )
                  VALUES (
                      5,
                      'Album5',
                      64,
                      2004
                  );

INSERT INTO ALBUM (
                      Inventory_ID,
                      Name,
                      Length,
                      Year
                  )
                  VALUES (
                      6,
                      'Album6',
                      65,
                      2005
                  );

INSERT INTO ALBUM (
                      Inventory_ID,
                      Name,
                      Length,
                      Year
                  )
                  VALUES (
                      7,
                      'Album7',
                      66,
                      2006
                  );

INSERT INTO ALBUM (
                      Inventory_ID,
                      Name,
                      Length,
                      Year
                  )
                  VALUES (
                      8,
                      'Album8',
                      67,
                      2007
                  );

INSERT INTO ALBUM (
                      Inventory_ID,
                      Name,
                      Length,
                      Year
                  )
                  VALUES (
                      9,
                      'Album9',
                      68,
                      2008
                  );

INSERT INTO ALBUM (
                      Inventory_ID,
                      Name,
                      Length,
                      Year
                  )
                  VALUES (
                      10,
                      'Album10',
                      69,
                      2009
                  );

INSERT INTO ALBUM (
                      Inventory_ID,
                      Name,
                      Length,
                      Year
                  )
                  VALUES (
                      11,
                      'Album11',
                      60,
                      2000
                  );

INSERT INTO ALBUM (
                      Inventory_ID,
                      Name,
                      Length,
                      Year
                  )
                  VALUES (
                      12,
                      'Album12',
                      61,
                      2001
                  );

INSERT INTO ALBUM (
                      Inventory_ID,
                      Name,
                      Length,
                      Year
                  )
                  VALUES (
                      13,
                      'Album13',
                      62,
                      2002
                  );

INSERT INTO ALBUM (
                      Inventory_ID,
                      Name,
                      Length,
                      Year
                  )
                  VALUES (
                      14,
                      'Album14',
                      63,
                      2003
                  );

INSERT INTO ALBUM (
                      Inventory_ID,
                      Name,
                      Length,
                      Year
                  )
                  VALUES (
                      15,
                      'Album15',
                      64,
                      2004
                  );

INSERT INTO ALBUM (
                      Inventory_ID,
                      Name,
                      Length,
                      Year
                  )
                  VALUES (
                      16,
                      'Album16',
                      65,
                      2005
                  );

INSERT INTO ALBUM (
                      Inventory_ID,
                      Name,
                      Length,
                      Year
                  )
                  VALUES (
                      17,
                      'Album17',
                      66,
                      2006
                  );

INSERT INTO ALBUM (
                      Inventory_ID,
                      Name,
                      Length,
                      Year
                  )
                  VALUES (
                      18,
                      'Album18',
                      67,
                      2007
                  );

INSERT INTO ALBUM (
                      Inventory_ID,
                      Name,
                      Length,
                      Year
                  )
                  VALUES (
                      19,
                      'Album19',
                      68,
                      2008
                  );

INSERT INTO ALBUM (
                      Inventory_ID,
                      Name,
                      Length,
                      Year
                  )
                  VALUES (
                      20,
                      'Album20',
                      69,
                      2009
                  );


-- Table: ALBUM_ARTIST
CREATE TABLE ALBUM_ARTIST (
    Inventory_ID INTEGER REFERENCES INVENTORY_ITEM (Inventory_ID) ON DELETE CASCADE
                         PRIMARY KEY,
    Artist_ID    INTEGER REFERENCES ARTIST (Artist_ID) ON DELETE CASCADE
);

INSERT INTO ALBUM_ARTIST (
                             Inventory_ID,
                             Artist_ID
                         )
                         VALUES (
                             1,
                             1
                         );

INSERT INTO ALBUM_ARTIST (
                             Inventory_ID,
                             Artist_ID
                         )
                         VALUES (
                             2,
                             2
                         );

INSERT INTO ALBUM_ARTIST (
                             Inventory_ID,
                             Artist_ID
                         )
                         VALUES (
                             3,
                             3
                         );

INSERT INTO ALBUM_ARTIST (
                             Inventory_ID,
                             Artist_ID
                         )
                         VALUES (
                             4,
                             4
                         );

INSERT INTO ALBUM_ARTIST (
                             Inventory_ID,
                             Artist_ID
                         )
                         VALUES (
                             5,
                             5
                         );

INSERT INTO ALBUM_ARTIST (
                             Inventory_ID,
                             Artist_ID
                         )
                         VALUES (
                             6,
                             6
                         );

INSERT INTO ALBUM_ARTIST (
                             Inventory_ID,
                             Artist_ID
                         )
                         VALUES (
                             7,
                             7
                         );

INSERT INTO ALBUM_ARTIST (
                             Inventory_ID,
                             Artist_ID
                         )
                         VALUES (
                             8,
                             8
                         );

INSERT INTO ALBUM_ARTIST (
                             Inventory_ID,
                             Artist_ID
                         )
                         VALUES (
                             9,
                             9
                         );

INSERT INTO ALBUM_ARTIST (
                             Inventory_ID,
                             Artist_ID
                         )
                         VALUES (
                             10,
                             10
                         );

INSERT INTO ALBUM_ARTIST (
                             Inventory_ID,
                             Artist_ID
                         )
                         VALUES (
                             11,
                             11
                         );

INSERT INTO ALBUM_ARTIST (
                             Inventory_ID,
                             Artist_ID
                         )
                         VALUES (
                             12,
                             12
                         );

INSERT INTO ALBUM_ARTIST (
                             Inventory_ID,
                             Artist_ID
                         )
                         VALUES (
                             13,
                             13
                         );

INSERT INTO ALBUM_ARTIST (
                             Inventory_ID,
                             Artist_ID
                         )
                         VALUES (
                             14,
                             14
                         );

INSERT INTO ALBUM_ARTIST (
                             Inventory_ID,
                             Artist_ID
                         )
                         VALUES (
                             15,
                             15
                         );

INSERT INTO ALBUM_ARTIST (
                             Inventory_ID,
                             Artist_ID
                         )
                         VALUES (
                             16,
                             16
                         );

INSERT INTO ALBUM_ARTIST (
                             Inventory_ID,
                             Artist_ID
                         )
                         VALUES (
                             17,
                             17
                         );

INSERT INTO ALBUM_ARTIST (
                             Inventory_ID,
                             Artist_ID
                         )
                         VALUES (
                             18,
                             18
                         );

INSERT INTO ALBUM_ARTIST (
                             Inventory_ID,
                             Artist_ID
                         )
                         VALUES (
                             19,
                             19
                         );

INSERT INTO ALBUM_ARTIST (
                             Inventory_ID,
                             Artist_ID
                         )
                         VALUES (
                             20,
                             20
                         );


-- Table: ARTIST
CREATE TABLE ARTIST (
    Artist_ID INTEGER      PRIMARY KEY
                           UNIQUE
                           NOT NULL,
    Name      VARCHAR (50) 
);

INSERT INTO ARTIST (
                       Artist_ID,
                       Name
                   )
                   VALUES (
                       1,
                       'Angel'
                   );

INSERT INTO ARTIST (
                       Artist_ID,
                       Name
                   )
                   VALUES (
                       2,
                       'Colton'
                   );

INSERT INTO ARTIST (
                       Artist_ID,
                       Name
                   )
                   VALUES (
                       3,
                       'Hunter'
                   );

INSERT INTO ARTIST (
                       Artist_ID,
                       Name
                   )
                   VALUES (
                       4,
                       'Robert'
                   );

INSERT INTO ARTIST (
                       Artist_ID,
                       Name
                   )
                   VALUES (
                       5,
                       'Jordan'
                   );

INSERT INTO ARTIST (
                       Artist_ID,
                       Name
                   )
                   VALUES (
                       6,
                       'Ian'
                   );

INSERT INTO ARTIST (
                       Artist_ID,
                       Name
                   )
                   VALUES (
                       7,
                       'Carson'
                   );

INSERT INTO ARTIST (
                       Artist_ID,
                       Name
                   )
                   VALUES (
                       8,
                       'Dominic'
                   );

INSERT INTO ARTIST (
                       Artist_ID,
                       Name
                   )
                   VALUES (
                       9,
                       'Austin'
                   );

INSERT INTO ARTIST (
                       Artist_ID,
                       Name
                   )
                   VALUES (
                       10,
                       'Brooks'
                   );

INSERT INTO ARTIST (
                       Artist_ID,
                       Name
                   )
                   VALUES (
                       11,
                       'Xavier'
                   );

INSERT INTO ARTIST (
                       Artist_ID,
                       Name
                   )
                   VALUES (
                       12,
                       'Kai'
                   );

INSERT INTO ARTIST (
                       Artist_ID,
                       Name
                   )
                   VALUES (
                       13,
                       'Jace'
                   );

INSERT INTO ARTIST (
                       Artist_ID,
                       Name
                   )
                   VALUES (
                       14,
                       'Adam'
                   );

INSERT INTO ARTIST (
                       Artist_ID,
                       Name
                   )
                   VALUES (
                       15,
                       'Jose'
                   );

INSERT INTO ARTIST (
                       Artist_ID,
                       Name
                   )
                   VALUES (
                       16,
                       'Damian'
                   );

INSERT INTO ARTIST (
                       Artist_ID,
                       Name
                   )
                   VALUES (
                       17,
                       'Kingston'
                   );

INSERT INTO ARTIST (
                       Artist_ID,
                       Name
                   )
                   VALUES (
                       18,
                       'Tyler'
                   );

INSERT INTO ARTIST (
                       Artist_ID,
                       Name
                   )
                   VALUES (
                       19,
                       'George'
                   );

INSERT INTO ARTIST (
                       Artist_ID,
                       Name
                   )
                   VALUES (
                       20,
                       'Milo'
                   );


-- Table: AUDIOBOOK
CREATE TABLE AUDIOBOOK (
    Inventory_ID INTEGER      PRIMARY KEY
                              REFERENCES INVENTORY_ITEM (Inventory_ID) ON DELETE CASCADE,
    Author_ID    INTEGER      REFERENCES AUTHOR (Author_ID) ON DELETE CASCADE,
    Length       INTEGER,
    Year         INTEGER,
    Name         VARCHAR (50),
    Reader       VARCHAR (50) 
);

INSERT INTO AUDIOBOOK (
                          Inventory_ID,
                          Author_ID,
                          Length,
                          Year,
                          Name,
                          Reader
                      )
                      VALUES (
                          21,
                          1,
                          60,
                          2000,
                          'Audiobook21',
                          'Prince'
                      );

INSERT INTO AUDIOBOOK (
                          Inventory_ID,
                          Author_ID,
                          Length,
                          Year,
                          Name,
                          Reader
                      )
                      VALUES (
                          22,
                          2,
                          61,
                          2001,
                          'Audiobook22',
                          'Gunner'
                      );

INSERT INTO AUDIOBOOK (
                          Inventory_ID,
                          Author_ID,
                          Length,
                          Year,
                          Name,
                          Reader
                      )
                      VALUES (
                          23,
                          3,
                          62,
                          2002,
                          'Audiobook23',
                          'Zayn'
                      );

INSERT INTO AUDIOBOOK (
                          Inventory_ID,
                          Author_ID,
                          Length,
                          Year,
                          Name,
                          Reader
                      )
                      VALUES (
                          24,
                          4,
                          63,
                          2003,
                          'Audiobook24',
                          'Derek'
                      );

INSERT INTO AUDIOBOOK (
                          Inventory_ID,
                          Author_ID,
                          Length,
                          Year,
                          Name,
                          Reader
                      )
                      VALUES (
                          25,
                          5,
                          64,
                          2004,
                          'Audiobook25',
                          'Raymond'
                      );

INSERT INTO AUDIOBOOK (
                          Inventory_ID,
                          Author_ID,
                          Length,
                          Year,
                          Name,
                          Reader
                      )
                      VALUES (
                          26,
                          6,
                          65,
                          2005,
                          'Audiobook26',
                          'Kyle'
                      );

INSERT INTO AUDIOBOOK (
                          Inventory_ID,
                          Author_ID,
                          Length,
                          Year,
                          Name,
                          Reader
                      )
                      VALUES (
                          27,
                          7,
                          66,
                          2006,
                          'Audiobook27',
                          'Reid'
                      );

INSERT INTO AUDIOBOOK (
                          Inventory_ID,
                          Author_ID,
                          Length,
                          Year,
                          Name,
                          Reader
                      )
                      VALUES (
                          28,
                          8,
                          67,
                          2007,
                          'Audiobook28',
                          'Spencer'
                      );

INSERT INTO AUDIOBOOK (
                          Inventory_ID,
                          Author_ID,
                          Length,
                          Year,
                          Name,
                          Reader
                      )
                      VALUES (
                          29,
                          9,
                          68,
                          2008,
                          'Audiobook29',
                          'Nico'
                      );

INSERT INTO AUDIOBOOK (
                          Inventory_ID,
                          Author_ID,
                          Length,
                          Year,
                          Name,
                          Reader
                      )
                      VALUES (
                          30,
                          10,
                          69,
                          2009,
                          'Audiobook30',
                          'Jaylen'
                      );

INSERT INTO AUDIOBOOK (
                          Inventory_ID,
                          Author_ID,
                          Length,
                          Year,
                          Name,
                          Reader
                      )
                      VALUES (
                          31,
                          11,
                          60,
                          2000,
                          'Audiobook31',
                          'Jake'
                      );

INSERT INTO AUDIOBOOK (
                          Inventory_ID,
                          Author_ID,
                          Length,
                          Year,
                          Name,
                          Reader
                      )
                      VALUES (
                          32,
                          12,
                          61,
                          2001,
                          'Audiobook32',
                          'Manuel'
                      );

INSERT INTO AUDIOBOOK (
                          Inventory_ID,
                          Author_ID,
                          Length,
                          Year,
                          Name,
                          Reader
                      )
                      VALUES (
                          33,
                          13,
                          62,
                          2002,
                          'Audiobook33',
                          'Gideon'
                      );

INSERT INTO AUDIOBOOK (
                          Inventory_ID,
                          Author_ID,
                          Length,
                          Year,
                          Name,
                          Reader
                      )
                      VALUES (
                          34,
                          14,
                          63,
                          2003,
                          'Audiobook34',
                          'Ali'
                      );

INSERT INTO AUDIOBOOK (
                          Inventory_ID,
                          Author_ID,
                          Length,
                          Year,
                          Name,
                          Reader
                      )
                      VALUES (
                          35,
                          15,
                          64,
                          2004,
                          'Audiobook35',
                          'Ellis'
                      );

INSERT INTO AUDIOBOOK (
                          Inventory_ID,
                          Author_ID,
                          Length,
                          Year,
                          Name,
                          Reader
                      )
                      VALUES (
                          36,
                          16,
                          65,
                          2005,
                          'Audiobook36',
                          'Stephen'
                      );

INSERT INTO AUDIOBOOK (
                          Inventory_ID,
                          Author_ID,
                          Length,
                          Year,
                          Name,
                          Reader
                      )
                      VALUES (
                          37,
                          17,
                          66,
                          2006,
                          'Audiobook37',
                          'Orion'
                      );

INSERT INTO AUDIOBOOK (
                          Inventory_ID,
                          Author_ID,
                          Length,
                          Year,
                          Name,
                          Reader
                      )
                      VALUES (
                          38,
                          18,
                          67,
                          2007,
                          'Audiobook38',
                          'Rylan'
                      );

INSERT INTO AUDIOBOOK (
                          Inventory_ID,
                          Author_ID,
                          Length,
                          Year,
                          Name,
                          Reader
                      )
                      VALUES (
                          39,
                          19,
                          68,
                          2008,
                          'Audiobook39',
                          'Eduardo'
                      );

INSERT INTO AUDIOBOOK (
                          Inventory_ID,
                          Author_ID,
                          Length,
                          Year,
                          Name,
                          Reader
                      )
                      VALUES (
                          40,
                          20,
                          69,
                          2009,
                          'Audiobook40',
                          'Odin'
                      );


-- Table: AUTHOR
CREATE TABLE AUTHOR (
    Author_ID INTEGER      PRIMARY KEY
                           UNIQUE
                           NOT NULL,
    Name      VARCHAR (50) 
);

INSERT INTO AUTHOR (
                       Author_ID,
                       Name
                   )
                   VALUES (
                       1,
                       'August'
                   );

INSERT INTO AUTHOR (
                       Author_ID,
                       Name
                   )
                   VALUES (
                       2,
                       'Karter'
                   );

INSERT INTO AUTHOR (
                       Author_ID,
                       Name
                   )
                   VALUES (
                       3,
                       'Arthur'
                   );

INSERT INTO AUTHOR (
                       Author_ID,
                       Name
                   )
                   VALUES (
                       4,
                       'Thiago'
                   );

INSERT INTO AUTHOR (
                       Author_ID,
                       Name
                   )
                   VALUES (
                       5,
                       'Brandon'
                   );

INSERT INTO AUTHOR (
                       Author_ID,
                       Name
                   )
                   VALUES (
                       6,
                       'Emmanuel'
                   );

INSERT INTO AUTHOR (
                       Author_ID,
                       Name
                   )
                   VALUES (
                       7,
                       'Dean'
                   );

INSERT INTO AUTHOR (
                       Author_ID,
                       Name
                   )
                   VALUES (
                       8,
                       'Hayden'
                   );

INSERT INTO AUTHOR (
                       Author_ID,
                       Name
                   )
                   VALUES (
                       9,
                       'Camden'
                   );

INSERT INTO AUTHOR (
                       Author_ID,
                       Name
                   )
                   VALUES (
                       10,
                       'Justin'
                   );

INSERT INTO AUTHOR (
                       Author_ID,
                       Name
                   )
                   VALUES (
                       11,
                       'Jesus'
                   );

INSERT INTO AUTHOR (
                       Author_ID,
                       Name
                   )
                   VALUES (
                       12,
                       'King'
                   );

INSERT INTO AUTHOR (
                       Author_ID,
                       Name
                   )
                   VALUES (
                       13,
                       'Theo'
                   );

INSERT INTO AUTHOR (
                       Author_ID,
                       Name
                   )
                   VALUES (
                       14,
                       'Finn'
                   );

INSERT INTO AUTHOR (
                       Author_ID,
                       Name
                   )
                   VALUES (
                       15,
                       'Graham'
                   );

INSERT INTO AUTHOR (
                       Author_ID,
                       Name
                   )
                   VALUES (
                       16,
                       'Miguel'
                   );

INSERT INTO AUTHOR (
                       Author_ID,
                       Name
                   )
                   VALUES (
                       17,
                       'Atlas'
                   );

INSERT INTO AUTHOR (
                       Author_ID,
                       Name
                   )
                   VALUES (
                       18,
                       'Dawson'
                   );

INSERT INTO AUTHOR (
                       Author_ID,
                       Name
                   )
                   VALUES (
                       19,
                       'Eric'
                   );

INSERT INTO AUTHOR (
                       Author_ID,
                       Name
                   )
                   VALUES (
                       20,
                       'Victor'
                   );


-- Table: CARD
CREATE TABLE CARD (
    Card_ID            INTEGER PRIMARY KEY
                               UNIQUE
                               NOT NULL,
    Card_Creation_Date DATE    NOT NULL
);

INSERT INTO CARD (
                     Card_ID,
                     Card_Creation_Date
                 )
                 VALUES (
                     1,
                     '2001-01-01'
                 );

INSERT INTO CARD (
                     Card_ID,
                     Card_Creation_Date
                 )
                 VALUES (
                     2,
                     '2002-01-01'
                 );

INSERT INTO CARD (
                     Card_ID,
                     Card_Creation_Date
                 )
                 VALUES (
                     3,
                     '2003-01-01'
                 );

INSERT INTO CARD (
                     Card_ID,
                     Card_Creation_Date
                 )
                 VALUES (
                     4,
                     '2004-01-01'
                 );

INSERT INTO CARD (
                     Card_ID,
                     Card_Creation_Date
                 )
                 VALUES (
                     5,
                     '2005-01-01'
                 );

INSERT INTO CARD (
                     Card_ID,
                     Card_Creation_Date
                 )
                 VALUES (
                     6,
                     '2006-01-01'
                 );

INSERT INTO CARD (
                     Card_ID,
                     Card_Creation_Date
                 )
                 VALUES (
                     7,
                     '2007-01-01'
                 );

INSERT INTO CARD (
                     Card_ID,
                     Card_Creation_Date
                 )
                 VALUES (
                     8,
                     '2008-01-01'
                 );

INSERT INTO CARD (
                     Card_ID,
                     Card_Creation_Date
                 )
                 VALUES (
                     9,
                     '2009-01-01'
                 );

INSERT INTO CARD (
                     Card_ID,
                     Card_Creation_Date
                 )
                 VALUES (
                     10,
                     '2010-01-01'
                 );

INSERT INTO CARD (
                     Card_ID,
                     Card_Creation_Date
                 )
                 VALUES (
                     11,
                     '2011-01-01'
                 );

INSERT INTO CARD (
                     Card_ID,
                     Card_Creation_Date
                 )
                 VALUES (
                     12,
                     '2012-01-01'
                 );

INSERT INTO CARD (
                     Card_ID,
                     Card_Creation_Date
                 )
                 VALUES (
                     13,
                     '2013-01-01'
                 );

INSERT INTO CARD (
                     Card_ID,
                     Card_Creation_Date
                 )
                 VALUES (
                     14,
                     '2014-01-01'
                 );

INSERT INTO CARD (
                     Card_ID,
                     Card_Creation_Date
                 )
                 VALUES (
                     15,
                     '2015-01-01'
                 );

INSERT INTO CARD (
                     Card_ID,
                     Card_Creation_Date
                 )
                 VALUES (
                     16,
                     '2016-01-01'
                 );

INSERT INTO CARD (
                     Card_ID,
                     Card_Creation_Date
                 )
                 VALUES (
                     17,
                     '2017-01-01'
                 );

INSERT INTO CARD (
                     Card_ID,
                     Card_Creation_Date
                 )
                 VALUES (
                     18,
                     '2018-01-01'
                 );

INSERT INTO CARD (
                     Card_ID,
                     Card_Creation_Date
                 )
                 VALUES (
                     19,
                     '2019-01-01'
                 );

INSERT INTO CARD (
                     Card_ID,
                     Card_Creation_Date
                 )
                 VALUES (
                     20,
                     '2020-01-01'
                 );


-- Table: CHAPTER
CREATE TABLE CHAPTER (
    Inventory_ID INTEGER      REFERENCES AUDIOBOOK (Inventory_ID) ON DELETE CASCADE,
    Name         VARCHAR (50),
    Length       INTEGER,
    PRIMARY KEY (
        Inventory_ID,
        Name
    )
);


-- Table: CHECKOUT
CREATE TABLE CHECKOUT (
    Checkout_ID     INTEGER      PRIMARY KEY
                                 UNIQUE
                                 NOT NULL,
    Card_ID         INTEGER      REFERENCES CARD (Card_ID) ON DELETE CASCADE,
    Inventory_ID    INTEGER      REFERENCES INVENTORY_ITEM (Inventory_ID) ON DELETE CASCADE,
    Return_Date     DATE,
    Checkout_Status VARCHAR (50),
    Start_Date      DATE,
    Due_Date        DATE
);

INSERT INTO CHECKOUT (
                         Checkout_ID,
                         Card_ID,
                         Inventory_ID,
                         Return_Date,
                         Checkout_Status,
                         Start_Date,
                         Due_Date
                     )
                     VALUES (
                         1,
                         1,
                         1,
                         NULL,
                         'CheckedOut',
                         '2020-01-01',
                         '2020-01-11'
                     );

INSERT INTO CHECKOUT (
                         Checkout_ID,
                         Card_ID,
                         Inventory_ID,
                         Return_Date,
                         Checkout_Status,
                         Start_Date,
                         Due_Date
                     )
                     VALUES (
                         2,
                         1,
                         2,
                         NULL,
                         'CheckedOut',
                         '2020-01-02',
                         '2020-01-12'
                     );

INSERT INTO CHECKOUT (
                         Checkout_ID,
                         Card_ID,
                         Inventory_ID,
                         Return_Date,
                         Checkout_Status,
                         Start_Date,
                         Due_Date
                     )
                     VALUES (
                         3,
                         1,
                         3,
                         NULL,
                         'CheckedOut',
                         '2020-01-03',
                         '2020-01-13'
                     );

INSERT INTO CHECKOUT (
                         Checkout_ID,
                         Card_ID,
                         Inventory_ID,
                         Return_Date,
                         Checkout_Status,
                         Start_Date,
                         Due_Date
                     )
                     VALUES (
                         4,
                         2,
                         4,
                         NULL,
                         'CheckedOut',
                         '2020-01-04',
                         '2020-01-14'
                     );

INSERT INTO CHECKOUT (
                         Checkout_ID,
                         Card_ID,
                         Inventory_ID,
                         Return_Date,
                         Checkout_Status,
                         Start_Date,
                         Due_Date
                     )
                     VALUES (
                         5,
                         2,
                         5,
                         NULL,
                         'CheckedOut',
                         '2020-01-05',
                         '2020-01-15'
                     );

INSERT INTO CHECKOUT (
                         Checkout_ID,
                         Card_ID,
                         Inventory_ID,
                         Return_Date,
                         Checkout_Status,
                         Start_Date,
                         Due_Date
                     )
                     VALUES (
                         6,
                         3,
                         6,
                         NULL,
                         'CheckedOut',
                         '2020-01-06',
                         '2020-01-16'
                     );

INSERT INTO CHECKOUT (
                         Checkout_ID,
                         Card_ID,
                         Inventory_ID,
                         Return_Date,
                         Checkout_Status,
                         Start_Date,
                         Due_Date
                     )
                     VALUES (
                         7,
                         4,
                         7,
                         NULL,
                         'CheckedOut',
                         '2020-01-07',
                         '2020-01-17'
                     );

INSERT INTO CHECKOUT (
                         Checkout_ID,
                         Card_ID,
                         Inventory_ID,
                         Return_Date,
                         Checkout_Status,
                         Start_Date,
                         Due_Date
                     )
                     VALUES (
                         8,
                         5,
                         8,
                         NULL,
                         'CheckedOut',
                         '2020-01-08',
                         '2020-01-18'
                     );

INSERT INTO CHECKOUT (
                         Checkout_ID,
                         Card_ID,
                         Inventory_ID,
                         Return_Date,
                         Checkout_Status,
                         Start_Date,
                         Due_Date
                     )
                     VALUES (
                         9,
                         5,
                         9,
                         NULL,
                         'CheckedOut',
                         '2020-01-09',
                         '2020-01-19'
                     );

INSERT INTO CHECKOUT (
                         Checkout_ID,
                         Card_ID,
                         Inventory_ID,
                         Return_Date,
                         Checkout_Status,
                         Start_Date,
                         Due_Date
                     )
                     VALUES (
                         10,
                         6,
                         10,
                         NULL,
                         'CheckedOut',
                         '2020-01-10',
                         '2020-01-20'
                     );

INSERT INTO CHECKOUT (
                         Checkout_ID,
                         Card_ID,
                         Inventory_ID,
                         Return_Date,
                         Checkout_Status,
                         Start_Date,
                         Due_Date
                     )
                     VALUES (
                         11,
                         7,
                         11,
                         NULL,
                         'CheckedOut',
                         '2020-01-01',
                         '2020-01-11'
                     );

INSERT INTO CHECKOUT (
                         Checkout_ID,
                         Card_ID,
                         Inventory_ID,
                         Return_Date,
                         Checkout_Status,
                         Start_Date,
                         Due_Date
                     )
                     VALUES (
                         12,
                         8,
                         12,
                         NULL,
                         'CheckedOut',
                         '2020-01-02',
                         '2020-01-12'
                     );

INSERT INTO CHECKOUT (
                         Checkout_ID,
                         Card_ID,
                         Inventory_ID,
                         Return_Date,
                         Checkout_Status,
                         Start_Date,
                         Due_Date
                     )
                     VALUES (
                         13,
                         9,
                         13,
                         NULL,
                         'CheckedOut',
                         '2020-01-03',
                         '2020-01-13'
                     );

INSERT INTO CHECKOUT (
                         Checkout_ID,
                         Card_ID,
                         Inventory_ID,
                         Return_Date,
                         Checkout_Status,
                         Start_Date,
                         Due_Date
                     )
                     VALUES (
                         14,
                         9,
                         14,
                         NULL,
                         'CheckedOut',
                         '2020-01-04',
                         '2020-01-14'
                     );

INSERT INTO CHECKOUT (
                         Checkout_ID,
                         Card_ID,
                         Inventory_ID,
                         Return_Date,
                         Checkout_Status,
                         Start_Date,
                         Due_Date
                     )
                     VALUES (
                         15,
                         10,
                         15,
                         NULL,
                         'CheckedOut',
                         '2020-01-05',
                         '2020-01-15'
                     );

INSERT INTO CHECKOUT (
                         Checkout_ID,
                         Card_ID,
                         Inventory_ID,
                         Return_Date,
                         Checkout_Status,
                         Start_Date,
                         Due_Date
                     )
                     VALUES (
                         16,
                         11,
                         16,
                         NULL,
                         'CheckedOut',
                         '2020-01-06',
                         '2020-01-16'
                     );

INSERT INTO CHECKOUT (
                         Checkout_ID,
                         Card_ID,
                         Inventory_ID,
                         Return_Date,
                         Checkout_Status,
                         Start_Date,
                         Due_Date
                     )
                     VALUES (
                         17,
                         12,
                         17,
                         NULL,
                         'CheckedOut',
                         '2020-01-07',
                         '2020-01-17'
                     );

INSERT INTO CHECKOUT (
                         Checkout_ID,
                         Card_ID,
                         Inventory_ID,
                         Return_Date,
                         Checkout_Status,
                         Start_Date,
                         Due_Date
                     )
                     VALUES (
                         18,
                         12,
                         18,
                         NULL,
                         'CheckedOut',
                         '2020-01-08',
                         '2020-01-18'
                     );

INSERT INTO CHECKOUT (
                         Checkout_ID,
                         Card_ID,
                         Inventory_ID,
                         Return_Date,
                         Checkout_Status,
                         Start_Date,
                         Due_Date
                     )
                     VALUES (
                         19,
                         13,
                         19,
                         NULL,
                         'CheckedOut',
                         '2020-01-09',
                         '2020-01-19'
                     );

INSERT INTO CHECKOUT (
                         Checkout_ID,
                         Card_ID,
                         Inventory_ID,
                         Return_Date,
                         Checkout_Status,
                         Start_Date,
                         Due_Date
                     )
                     VALUES (
                         20,
                         14,
                         20,
                         NULL,
                         'CheckedOut',
                         '2020-01-10',
                         '2020-01-20'
                     );


-- Table: DIRECTOR
CREATE TABLE DIRECTOR (
    Director_ID INTEGER      PRIMARY KEY
                             UNIQUE
                             NOT NULL,
    Name        VARCHAR (50) 
);

INSERT INTO DIRECTOR (
                         Director_ID,
                         Name
                     )
                     VALUES (
                         1,
                         'Bob'
                     );

INSERT INTO DIRECTOR (
                         Director_ID,
                         Name
                     )
                     VALUES (
                         2,
                         'James'
                     );

INSERT INTO DIRECTOR (
                         Director_ID,
                         Name
                     )
                     VALUES (
                         3,
                         'John'
                     );

INSERT INTO DIRECTOR (
                         Director_ID,
                         Name
                     )
                     VALUES (
                         4,
                         'Sam'
                     );

INSERT INTO DIRECTOR (
                         Director_ID,
                         Name
                     )
                     VALUES (
                         5,
                         'Liam'
                     );

INSERT INTO DIRECTOR (
                         Director_ID,
                         Name
                     )
                     VALUES (
                         6,
                         'Noah'
                     );

INSERT INTO DIRECTOR (
                         Director_ID,
                         Name
                     )
                     VALUES (
                         7,
                         'Oliver'
                     );

INSERT INTO DIRECTOR (
                         Director_ID,
                         Name
                     )
                     VALUES (
                         8,
                         'William'
                     );

INSERT INTO DIRECTOR (
                         Director_ID,
                         Name
                     )
                     VALUES (
                         9,
                         'Benjamin'
                     );

INSERT INTO DIRECTOR (
                         Director_ID,
                         Name
                     )
                     VALUES (
                         10,
                         'Lucas'
                     );

INSERT INTO DIRECTOR (
                         Director_ID,
                         Name
                     )
                     VALUES (
                         11,
                         'Alex'
                     );

INSERT INTO DIRECTOR (
                         Director_ID,
                         Name
                     )
                     VALUES (
                         12,
                         'Mason'
                     );

INSERT INTO DIRECTOR (
                         Director_ID,
                         Name
                     )
                     VALUES (
                         13,
                         'Michael'
                     );

INSERT INTO DIRECTOR (
                         Director_ID,
                         Name
                     )
                     VALUES (
                         14,
                         'Ethan'
                     );

INSERT INTO DIRECTOR (
                         Director_ID,
                         Name
                     )
                     VALUES (
                         15,
                         'Daniel'
                     );

INSERT INTO DIRECTOR (
                         Director_ID,
                         Name
                     )
                     VALUES (
                         16,
                         'Jacob'
                     );

INSERT INTO DIRECTOR (
                         Director_ID,
                         Name
                     )
                     VALUES (
                         17,
                         'Logan'
                     );

INSERT INTO DIRECTOR (
                         Director_ID,
                         Name
                     )
                     VALUES (
                         18,
                         'Jackson'
                     );

INSERT INTO DIRECTOR (
                         Director_ID,
                         Name
                     )
                     VALUES (
                         19,
                         'Levi'
                     );

INSERT INTO DIRECTOR (
                         Director_ID,
                         Name
                     )
                     VALUES (
                         20,
                         'Jack'
                     );


-- Table: DIRECTS
CREATE TABLE DIRECTS (
    Inventory_ID INTEGER PRIMARY KEY
                         REFERENCES INVENTORY_ITEM (Inventory_ID) ON DELETE CASCADE,
    Director_ID  INTEGER REFERENCES DIRECTOR (Director_ID) ON DELETE CASCADE
);

INSERT INTO DIRECTS (
                        Inventory_ID,
                        Director_ID
                    )
                    VALUES (
                        41,
                        1
                    );

INSERT INTO DIRECTS (
                        Inventory_ID,
                        Director_ID
                    )
                    VALUES (
                        42,
                        2
                    );

INSERT INTO DIRECTS (
                        Inventory_ID,
                        Director_ID
                    )
                    VALUES (
                        43,
                        3
                    );

INSERT INTO DIRECTS (
                        Inventory_ID,
                        Director_ID
                    )
                    VALUES (
                        44,
                        4
                    );

INSERT INTO DIRECTS (
                        Inventory_ID,
                        Director_ID
                    )
                    VALUES (
                        45,
                        5
                    );

INSERT INTO DIRECTS (
                        Inventory_ID,
                        Director_ID
                    )
                    VALUES (
                        46,
                        6
                    );

INSERT INTO DIRECTS (
                        Inventory_ID,
                        Director_ID
                    )
                    VALUES (
                        47,
                        7
                    );

INSERT INTO DIRECTS (
                        Inventory_ID,
                        Director_ID
                    )
                    VALUES (
                        48,
                        8
                    );

INSERT INTO DIRECTS (
                        Inventory_ID,
                        Director_ID
                    )
                    VALUES (
                        49,
                        9
                    );

INSERT INTO DIRECTS (
                        Inventory_ID,
                        Director_ID
                    )
                    VALUES (
                        50,
                        10
                    );

INSERT INTO DIRECTS (
                        Inventory_ID,
                        Director_ID
                    )
                    VALUES (
                        51,
                        11
                    );

INSERT INTO DIRECTS (
                        Inventory_ID,
                        Director_ID
                    )
                    VALUES (
                        52,
                        12
                    );

INSERT INTO DIRECTS (
                        Inventory_ID,
                        Director_ID
                    )
                    VALUES (
                        53,
                        13
                    );

INSERT INTO DIRECTS (
                        Inventory_ID,
                        Director_ID
                    )
                    VALUES (
                        54,
                        14
                    );

INSERT INTO DIRECTS (
                        Inventory_ID,
                        Director_ID
                    )
                    VALUES (
                        55,
                        15
                    );

INSERT INTO DIRECTS (
                        Inventory_ID,
                        Director_ID
                    )
                    VALUES (
                        56,
                        16
                    );

INSERT INTO DIRECTS (
                        Inventory_ID,
                        Director_ID
                    )
                    VALUES (
                        57,
                        17
                    );

INSERT INTO DIRECTS (
                        Inventory_ID,
                        Director_ID
                    )
                    VALUES (
                        58,
                        18
                    );

INSERT INTO DIRECTS (
                        Inventory_ID,
                        Director_ID
                    )
                    VALUES (
                        59,
                        19
                    );

INSERT INTO DIRECTS (
                        Inventory_ID,
                        Director_ID
                    )
                    VALUES (
                        60,
                        20
                    );


-- Table: EPISODE
CREATE TABLE EPISODE (
    Inventory_ID   INTEGER      REFERENCES SEASON (Inventory_ID) ON DELETE CASCADE,
    Season_Number  INTEGER      REFERENCES SEASON (Season_Number) ON DELETE CASCADE
                                                                  ON UPDATE CASCADE,
    Director_ID    INTEGER      REFERENCES DIRECTOR (Director_ID) ON DELETE SET NULL,
    Episode_Name   VARCHAR (50),
    Episode_Length INTEGER,
    PRIMARY KEY (
        Inventory_ID,
        Season_Number,
        Episode_Name
    )
);


-- Table: GENRE
CREATE TABLE GENRE (
    Genre_Name VARCHAR (50) PRIMARY KEY
                          UNIQUE
                          NOT NULL
);

INSERT INTO GENRE (
                      Genre_Name
                  )
                  VALUES (
                      'Fantasy'
                  );

INSERT INTO GENRE (
                      Genre_Name
                  )
                  VALUES (
                      'Science Fiction'
                  );

INSERT INTO GENRE (
                      Genre_Name
                  )
                  VALUES (
                      'Dystopian'
                  );

INSERT INTO GENRE (
                      Genre_Name
                  )
                  VALUES (
                      'Action'
                  );

INSERT INTO GENRE (
                      Genre_Name
                  )
                  VALUES (
                      'Adventure'
                  );

INSERT INTO GENRE (
                      Genre_Name
                  )
                  VALUES (
                      'Mystery'
                  );

INSERT INTO GENRE (
                      Genre_Name
                  )
                  VALUES (
                      'Horror'
                  );

INSERT INTO GENRE (
                      Genre_Name
                  )
                  VALUES (
                      'Thriller'
                  );

INSERT INTO GENRE (
                      Genre_Name
                  )
                  VALUES (
                      'History'
                  );

INSERT INTO GENRE (
                      Genre_Name
                  )
                  VALUES (
                      'Romance'
                  );

INSERT INTO GENRE (
                      Genre_Name
                  )
                  VALUES (
                      'Graphic Novel'
                  );

INSERT INTO GENRE (
                      Genre_Name
                  )
                  VALUES (
                      'Animation'
                  );

INSERT INTO GENRE (
                      Genre_Name
                  )
                  VALUES (
                      'Musical'
                  );

INSERT INTO GENRE (
                      Genre_Name
                  )
                  VALUES (
                      'Western'
                  );

INSERT INTO GENRE (
                      Genre_Name
                  )
                  VALUES (
                      'Comedy'
                  );

INSERT INTO GENRE (
                      Genre_Name
                  )
                  VALUES (
                      'Documentary'
                  );

INSERT INTO GENRE (
                      Genre_Name
                  )
                  VALUES (
                      'Crime'
                  );

INSERT INTO GENRE (
                      Genre_Name
                  )
                  VALUES (
                      'Sport'
                  );

INSERT INTO GENRE (
                      Genre_Name
                  )
                  VALUES (
                      'Biography'
                  );

INSERT INTO GENRE (
                      Genre_Name
                  )
                  VALUES (
                      'Drama'
                  );

INSERT INTO GENRE (
                      Genre_Name
                  )
                  VALUES (
                      'Family'
                  );

INSERT INTO GENRE (
                      Genre_Name
                  )
                  VALUES (
                      'Rock'
                  );

INSERT INTO GENRE (
                      Genre_Name
                  )
                  VALUES (
                      'Country'
                  );

INSERT INTO GENRE (
                      Genre_Name
                  )
                  VALUES (
                      'Pop'
                  );

INSERT INTO GENRE (
                      Genre_Name
                  )
                  VALUES (
                      'Hip-Hop'
                  );


-- Table: INVENTORY_ITEM
CREATE TABLE INVENTORY_ITEM (
    Inventory_ID INTEGER      PRIMARY KEY
                              UNIQUE
                              NOT NULL,
    Quantity     INTEGER,
    Format       VARCHAR (50),
    Location     VARCHAR (50) 
);

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               1,
                               2,
                               'mp3',
                               'Isle 1'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               2,
                               3,
                               'mp3',
                               'Isle 1'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               3,
                               2,
                               'mp3',
                               'Isle 1'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               4,
                               1,
                               'mp3',
                               'Isle 1'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               5,
                               2,
                               'mp3',
                               'Isle 1'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               6,
                               3,
                               'mp3',
                               'Isle 1'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               7,
                               4,
                               'mp3',
                               'Isle 1'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               8,
                               5,
                               'mp3',
                               'Isle 1'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               9,
                               3,
                               'mp3',
                               'Isle 1'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               10,
                               4,
                               'mp3',
                               'Isle 1'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               11,
                               6,
                               'mp3',
                               'Isle 2'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               12,
                               3,
                               'mp3',
                               'Isle 2'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               13,
                               2,
                               'mp3',
                               'Isle 2'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               14,
                               6,
                               'mp3',
                               'Isle 2'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               15,
                               7,
                               'mp3',
                               'Isle 2'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               16,
                               0,
                               'mp3',
                               'Isle 2'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               17,
                               1,
                               'mp3',
                               'Isle 2'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               18,
                               5,
                               'mp3',
                               'Isle 2'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               19,
                               3,
                               'mp3',
                               'Isle 2'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               20,
                               0,
                               'mp3',
                               'Isle 2'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               21,
                               2,
                               'mp3',
                               'Isle 3'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               22,
                               3,
                               'mp3',
                               'Isle 3'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               23,
                               6,
                               'mp3',
                               'Isle 3'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               24,
                               8,
                               'mp3',
                               'Isle 3'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               25,
                               3,
                               'mp3',
                               'Isle 3'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               26,
                               4,
                               'mp3',
                               'Isle 3'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               27,
                               5,
                               'mp3',
                               'Isle 3'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               28,
                               3,
                               'mp3',
                               'Isle 3'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               29,
                               4,
                               'mp3',
                               'Isle 3'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               30,
                               2,
                               'mp3',
                               'Isle 3'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               31,
                               6,
                               'mp3',
                               'Isle 4'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               32,
                               0,
                               'mp3',
                               'Isle 4'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               33,
                               0,
                               'mp3',
                               'Isle 4'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               34,
                               0,
                               'mp3',
                               'Isle 4'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               35,
                               1,
                               'mp3',
                               'Isle 4'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               36,
                               4,
                               'mp3',
                               'Isle 4'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               37,
                               2,
                               'mp3',
                               'Isle 4'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               38,
                               3,
                               'mp3',
                               'Isle 4'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               39,
                               2,
                               'mp3',
                               'Isle 4'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               40,
                               1,
                               'mp3',
                               'Isle 4'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               41,
                               1,
                               'DVD',
                               'Isle 5'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               42,
                               0,
                               'DVD',
                               'Isle 5'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               43,
                               12,
                               'DVD',
                               'Isle 5'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               44,
                               14,
                               'DVD',
                               'Isle 5'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               45,
                               15,
                               'DVD',
                               'Isle 5'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               46,
                               16,
                               'DVD',
                               'Isle 5'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               47,
                               12,
                               'DVD',
                               'Isle 5'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               48,
                               14,
                               'DVD',
                               'Isle 5'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               49,
                               12,
                               'DVD',
                               'Isle 5'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               50,
                               0,
                               'DVD',
                               'Isle 5'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               51,
                               4,
                               'DVD',
                               'Isle 6'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               52,
                               8,
                               'DVD',
                               'Isle 6'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               53,
                               6,
                               'DVD',
                               'Isle 6'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               54,
                               8,
                               'DVD',
                               'Isle 6'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               55,
                               5,
                               'DVD',
                               'Isle 6'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               56,
                               4,
                               'DVD',
                               'Isle 6'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               57,
                               23,
                               'DVD',
                               'Isle 6'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               58,
                               17,
                               'DVD',
                               'Isle 6'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               59,
                               0,
                               'DVD',
                               'Isle 6'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               60,
                               3,
                               'DVD',
                               'Isle 6'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               61,
                               5,
                               'DVD',
                               'Isle 7'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               62,
                               2,
                               'DVD',
                               'Isle 7'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               63,
                               3,
                               'DVD',
                               'Isle 7'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               64,
                               4,
                               'DVD',
                               'Isle 7'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               65,
                               2,
                               'DVD',
                               'Isle 7'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               66,
                               5,
                               'DVD',
                               'Isle 7'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               67,
                               1,
                               'DVD',
                               'Isle 7'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               68,
                               6,
                               'DVD',
                               'Isle 7'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               69,
                               0,
                               'DVD',
                               'Isle 7'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               70,
                               2,
                               'DVD',
                               'Isle 7'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               71,
                               5,
                               'DVD',
                               'Isle 8'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               72,
                               3,
                               'DVD',
                               'Isle 8'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               73,
                               6,
                               'DVD',
                               'Isle 8'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               74,
                               4,
                               'DVD',
                               'Isle 8'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               75,
                               0,
                               'DVD',
                               'Isle 8'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               76,
                               5,
                               'DVD',
                               'Isle 8'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               77,
                               3,
                               'DVD',
                               'Isle 8'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               78,
                               2,
                               'DVD',
                               'Isle 8'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               79,
                               4,
                               'DVD',
                               'Isle 8'
                           );

INSERT INTO INVENTORY_ITEM (
                               Inventory_ID,
                               Quantity,
                               Format,
                               Location
                           )
                           VALUES (
                               80,
                               1,
                               'DVD',
                               'Isle 8'
                           );


-- Table: MEDIA_GENRE
CREATE TABLE MEDIA_GENRE (
    Inventory_ID INTEGER      REFERENCES INVENTORY_ITEM (Inventory_ID) ON DELETE CASCADE
                              PRIMARY KEY,
    Genre_Name   VARCHAR (50) REFERENCES GENRE (Genre_Name) ON DELETE SET NULL
);

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            1,
                            'Rock'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            2,
                            'Country'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            3,
                            'Pop'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            4,
                            'Hip-Hop'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            5,
                            'Rock'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            6,
                            'Country'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            7,
                            'Pop'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            8,
                            'Hip-Hop'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            9,
                            'Rock'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            10,
                            'Country'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            11,
                            'Pop'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            12,
                            'Hip-Hop'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            13,
                            'Rock'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            14,
                            'Country'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            15,
                            'Pop'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            16,
                            'Hip-Hop'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            17,
                            'Rock'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            18,
                            'Country'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            19,
                            'Pop'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            20,
                            'Hip-Hop'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            21,
                            'Fantasy'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            22,
                            'Science Fiction'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            23,
                            'Dystopian'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            24,
                            'Action'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            25,
                            'Adventure'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            26,
                            'Mystery'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            27,
                            'Horror'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            28,
                            'Thriller'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            29,
                            'History'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            30,
                            'Romance'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            31,
                            'Graphic Novel'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            32,
                            'Fantasy'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            33,
                            'Science Fiction'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            34,
                            'Dystopian'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            35,
                            'Action'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            36,
                            'Adventure'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            37,
                            'Mystery'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            38,
                            'Horror'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            39,
                            'Thriller'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            40,
                            'History'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            41,
                            'Animation'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            42,
                            'Musical'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            43,
                            'Western'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            44,
                            'Comedy'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            45,
                            'Documentary'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            46,
                            'Crime'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            47,
                            'Sport'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            48,
                            'Biography'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            49,
                            'Drama'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            50,
                            'Family'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            51,
                            'Animation'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            52,
                            'Musical'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            53,
                            'Western'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            54,
                            'Comedy'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            55,
                            'Documentary'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            56,
                            'Crime'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            57,
                            'Sport'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            58,
                            'Biography'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            59,
                            'Drama'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            60,
                            'Family'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            61,
                            'Animation'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            62,
                            'Musical'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            63,
                            'Western'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            64,
                            'Comedy'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            65,
                            'Documentary'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            66,
                            'Crime'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            67,
                            'Sport'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            68,
                            'Biography'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            69,
                            'Drama'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            70,
                            'Family'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            71,
                            'Animation'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            72,
                            'Musical'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            73,
                            'Western'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            74,
                            'Comedy'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            75,
                            'Documentary'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            76,
                            'Crime'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            77,
                            'Sport'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            78,
                            'Biography'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            79,
                            'Drama'
                        );

INSERT INTO MEDIA_GENRE (
                            Inventory_ID,
                            Genre_Name
                        )
                        VALUES (
                            80,
                            'Family'
                        );


-- Table: MOVIE
CREATE TABLE MOVIE (
    Inventory_ID   INTEGER      PRIMARY KEY
                                REFERENCES INVENTORY_ITEM (Inventory_ID) ON DELETE CASCADE,
    Name           VARCHAR (50),
    Length         INTEGER,
    Year           INTEGER,
    Content_Rating VARCHAR (50) 
);

INSERT INTO MOVIE (
                      Inventory_ID,
                      Name,
                      Length,
                      Year,
                      Content_Rating
                  )
                  VALUES (
                      41,
                      'Movie41',
                      61,
                      2000,
                      'G'
                  );

INSERT INTO MOVIE (
                      Inventory_ID,
                      Name,
                      Length,
                      Year,
                      Content_Rating
                  )
                  VALUES (
                      42,
                      'Movie42',
                      62,
                      2001,
                      'PG'
                  );

INSERT INTO MOVIE (
                      Inventory_ID,
                      Name,
                      Length,
                      Year,
                      Content_Rating
                  )
                  VALUES (
                      43,
                      'Movie43',
                      63,
                      2002,
                      'PG-13'
                  );

INSERT INTO MOVIE (
                      Inventory_ID,
                      Name,
                      Length,
                      Year,
                      Content_Rating
                  )
                  VALUES (
                      44,
                      'Movie44',
                      64,
                      2003,
                      'R'
                  );

INSERT INTO MOVIE (
                      Inventory_ID,
                      Name,
                      Length,
                      Year,
                      Content_Rating
                  )
                  VALUES (
                      45,
                      'Movie45',
                      65,
                      2004,
                      'NC-17'
                  );

INSERT INTO MOVIE (
                      Inventory_ID,
                      Name,
                      Length,
                      Year,
                      Content_Rating
                  )
                  VALUES (
                      46,
                      'Movie46',
                      66,
                      2005,
                      'G'
                  );

INSERT INTO MOVIE (
                      Inventory_ID,
                      Name,
                      Length,
                      Year,
                      Content_Rating
                  )
                  VALUES (
                      47,
                      'Movie47',
                      67,
                      2006,
                      'PG'
                  );

INSERT INTO MOVIE (
                      Inventory_ID,
                      Name,
                      Length,
                      Year,
                      Content_Rating
                  )
                  VALUES (
                      48,
                      'Movie48',
                      68,
                      2007,
                      'PG-13'
                  );

INSERT INTO MOVIE (
                      Inventory_ID,
                      Name,
                      Length,
                      Year,
                      Content_Rating
                  )
                  VALUES (
                      49,
                      'Movie49',
                      69,
                      2008,
                      'R'
                  );

INSERT INTO MOVIE (
                      Inventory_ID,
                      Name,
                      Length,
                      Year,
                      Content_Rating
                  )
                  VALUES (
                      50,
                      'Movie50',
                      70,
                      2009,
                      'NC-17'
                  );

INSERT INTO MOVIE (
                      Inventory_ID,
                      Name,
                      Length,
                      Year,
                      Content_Rating
                  )
                  VALUES (
                      51,
                      'Movie51',
                      61,
                      2000,
                      'G'
                  );

INSERT INTO MOVIE (
                      Inventory_ID,
                      Name,
                      Length,
                      Year,
                      Content_Rating
                  )
                  VALUES (
                      52,
                      'Movie52',
                      62,
                      2001,
                      'PG'
                  );

INSERT INTO MOVIE (
                      Inventory_ID,
                      Name,
                      Length,
                      Year,
                      Content_Rating
                  )
                  VALUES (
                      53,
                      'Movie53',
                      63,
                      2002,
                      'PG-13'
                  );

INSERT INTO MOVIE (
                      Inventory_ID,
                      Name,
                      Length,
                      Year,
                      Content_Rating
                  )
                  VALUES (
                      54,
                      'Movie54',
                      64,
                      2003,
                      'R'
                  );

INSERT INTO MOVIE (
                      Inventory_ID,
                      Name,
                      Length,
                      Year,
                      Content_Rating
                  )
                  VALUES (
                      55,
                      'Movie55',
                      65,
                      2004,
                      'NC-17'
                  );

INSERT INTO MOVIE (
                      Inventory_ID,
                      Name,
                      Length,
                      Year,
                      Content_Rating
                  )
                  VALUES (
                      56,
                      'Movie56',
                      66,
                      2005,
                      'G'
                  );

INSERT INTO MOVIE (
                      Inventory_ID,
                      Name,
                      Length,
                      Year,
                      Content_Rating
                  )
                  VALUES (
                      57,
                      'Movie57',
                      67,
                      2006,
                      'PG'
                  );

INSERT INTO MOVIE (
                      Inventory_ID,
                      Name,
                      Length,
                      Year,
                      Content_Rating
                  )
                  VALUES (
                      58,
                      'Movie58',
                      68,
                      2007,
                      'PG-13'
                  );

INSERT INTO MOVIE (
                      Inventory_ID,
                      Name,
                      Length,
                      Year,
                      Content_Rating
                  )
                  VALUES (
                      59,
                      'Movie59',
                      69,
                      2008,
                      'R'
                  );

INSERT INTO MOVIE (
                      Inventory_ID,
                      Name,
                      Length,
                      Year,
                      Content_Rating
                  )
                  VALUES (
                      60,
                      'Movie60',
                      70,
                      2009,
                      'NC-17'
                  );


-- Table: ORDER
CREATE TABLE [ORDER] (
    Order_ID     INTEGER      PRIMARY KEY
                              UNIQUE
                              NOT NULL,
    P_Email      VARCHAR (50) REFERENCES PERSON (P_Email) ON DELETE CASCADE
                                                          ON UPDATE CASCADE,
    Seller_ID    INTEGER      REFERENCES SELLER (Seller_ID) ON DELETE CASCADE,
    Inventory_ID INTEGER      REFERENCES INVENTORY_ITEM (Inventory_ID) ON DELETE CASCADE,
    Date         DATE,
    ETA          DATE,
    Status       VARCHAR (50),
    Copies       INTEGER,
    Price        REAL
);

INSERT INTO [ORDER] (
                        Order_ID,
                        P_Email,
                        Seller_ID,
                        Inventory_ID,
                        Date,
                        ETA,
                        Status,
                        Copies,
                        Price
                    )
                    VALUES (
                        1,
                        '21@db.project',
                        1,
                        1,
                        '2020-01-01',
                        '2020-01-11',
                        'Pending',
                        2,
                        NULL
                    );

INSERT INTO [ORDER] (
                        Order_ID,
                        P_Email,
                        Seller_ID,
                        Inventory_ID,
                        Date,
                        ETA,
                        Status,
                        Copies,
                        Price
                    )
                    VALUES (
                        2,
                        '22@db.project',
                        2,
                        3,
                        '2020-01-02',
                        '2020-01-12',
                        'Pending',
                        4,
                        NULL
                    );

INSERT INTO [ORDER] (
                        Order_ID,
                        P_Email,
                        Seller_ID,
                        Inventory_ID,
                        Date,
                        ETA,
                        Status,
                        Copies,
                        Price
                    )
                    VALUES (
                        3,
                        '23@db.project',
                        3,
                        5,
                        '2020-01-03',
                        '2020-01-13',
                        'Pending',
                        3,
                        NULL
                    );

INSERT INTO [ORDER] (
                        Order_ID,
                        P_Email,
                        Seller_ID,
                        Inventory_ID,
                        Date,
                        ETA,
                        Status,
                        Copies,
                        Price
                    )
                    VALUES (
                        4,
                        '24@db.project',
                        4,
                        7,
                        '2020-01-04',
                        '2020-01-14',
                        'Pending',
                        5,
                        NULL
                    );

INSERT INTO [ORDER] (
                        Order_ID,
                        P_Email,
                        Seller_ID,
                        Inventory_ID,
                        Date,
                        ETA,
                        Status,
                        Copies,
                        Price
                    )
                    VALUES (
                        5,
                        '25@db.project',
                        5,
                        9,
                        '2020-01-05',
                        '2020-01-15',
                        'Pending',
                        1,
                        NULL
                    );

INSERT INTO [ORDER] (
                        Order_ID,
                        P_Email,
                        Seller_ID,
                        Inventory_ID,
                        Date,
                        ETA,
                        Status,
                        Copies,
                        Price
                    )
                    VALUES (
                        6,
                        '26@db.project',
                        6,
                        11,
                        '2020-01-06',
                        '2020-01-16',
                        'Pending',
                        3,
                        NULL
                    );

INSERT INTO [ORDER] (
                        Order_ID,
                        P_Email,
                        Seller_ID,
                        Inventory_ID,
                        Date,
                        ETA,
                        Status,
                        Copies,
                        Price
                    )
                    VALUES (
                        7,
                        '27@db.project',
                        7,
                        13,
                        '2020-01-07',
                        '2020-01-17',
                        'Pending',
                        2,
                        NULL
                    );

INSERT INTO [ORDER] (
                        Order_ID,
                        P_Email,
                        Seller_ID,
                        Inventory_ID,
                        Date,
                        ETA,
                        Status,
                        Copies,
                        Price
                    )
                    VALUES (
                        8,
                        '28@db.project',
                        8,
                        15,
                        '2020-01-08',
                        '2020-01-18',
                        'Pending',
                        4,
                        NULL
                    );

INSERT INTO [ORDER] (
                        Order_ID,
                        P_Email,
                        Seller_ID,
                        Inventory_ID,
                        Date,
                        ETA,
                        Status,
                        Copies,
                        Price
                    )
                    VALUES (
                        9,
                        '29@db.project',
                        9,
                        17,
                        '2020-01-09',
                        '2020-01-19',
                        'Pending',
                        3,
                        NULL
                    );

INSERT INTO [ORDER] (
                        Order_ID,
                        P_Email,
                        Seller_ID,
                        Inventory_ID,
                        Date,
                        ETA,
                        Status,
                        Copies,
                        Price
                    )
                    VALUES (
                        10,
                        '30@db.project',
                        10,
                        19,
                        '2020-01-10',
                        '2020-01-20',
                        'Pending',
                        7,
                        NULL
                    );

INSERT INTO [ORDER] (
                        Order_ID,
                        P_Email,
                        Seller_ID,
                        Inventory_ID,
                        Date,
                        ETA,
                        Status,
                        Copies,
                        Price
                    )
                    VALUES (
                        11,
                        '31@db.project',
                        11,
                        21,
                        '2020-01-01',
                        '2020-01-11',
                        'Pending',
                        5,
                        NULL
                    );

INSERT INTO [ORDER] (
                        Order_ID,
                        P_Email,
                        Seller_ID,
                        Inventory_ID,
                        Date,
                        ETA,
                        Status,
                        Copies,
                        Price
                    )
                    VALUES (
                        12,
                        '32@db.project',
                        12,
                        23,
                        '2020-01-02',
                        '2020-01-12',
                        'Pending',
                        4,
                        NULL
                    );

INSERT INTO [ORDER] (
                        Order_ID,
                        P_Email,
                        Seller_ID,
                        Inventory_ID,
                        Date,
                        ETA,
                        Status,
                        Copies,
                        Price
                    )
                    VALUES (
                        13,
                        '33@db.project',
                        13,
                        25,
                        '2020-01-03',
                        '2020-01-13',
                        'Pending',
                        6,
                        NULL
                    );

INSERT INTO [ORDER] (
                        Order_ID,
                        P_Email,
                        Seller_ID,
                        Inventory_ID,
                        Date,
                        ETA,
                        Status,
                        Copies,
                        Price
                    )
                    VALUES (
                        14,
                        '34@db.project',
                        14,
                        27,
                        '2020-01-04',
                        '2020-01-14',
                        'Pending',
                        12,
                        NULL
                    );

INSERT INTO [ORDER] (
                        Order_ID,
                        P_Email,
                        Seller_ID,
                        Inventory_ID,
                        Date,
                        ETA,
                        Status,
                        Copies,
                        Price
                    )
                    VALUES (
                        15,
                        '35@db.project',
                        15,
                        29,
                        '2020-01-05',
                        '2020-01-15',
                        'Pending',
                        9,
                        NULL
                    );

INSERT INTO [ORDER] (
                        Order_ID,
                        P_Email,
                        Seller_ID,
                        Inventory_ID,
                        Date,
                        ETA,
                        Status,
                        Copies,
                        Price
                    )
                    VALUES (
                        16,
                        '36@db.project',
                        16,
                        31,
                        '2020-01-06',
                        '2020-01-16',
                        'Pending',
                        5,
                        NULL
                    );

INSERT INTO [ORDER] (
                        Order_ID,
                        P_Email,
                        Seller_ID,
                        Inventory_ID,
                        Date,
                        ETA,
                        Status,
                        Copies,
                        Price
                    )
                    VALUES (
                        17,
                        '37@db.project',
                        17,
                        33,
                        '2020-01-07',
                        '2020-01-17',
                        'Pending',
                        3,
                        NULL
                    );

INSERT INTO [ORDER] (
                        Order_ID,
                        P_Email,
                        Seller_ID,
                        Inventory_ID,
                        Date,
                        ETA,
                        Status,
                        Copies,
                        Price
                    )
                    VALUES (
                        18,
                        '38@db.project',
                        18,
                        35,
                        '2020-01-08',
                        '2020-01-18',
                        'Pending',
                        2,
                        NULL
                    );

INSERT INTO [ORDER] (
                        Order_ID,
                        P_Email,
                        Seller_ID,
                        Inventory_ID,
                        Date,
                        ETA,
                        Status,
                        Copies,
                        Price
                    )
                    VALUES (
                        19,
                        '39@db.project',
                        19,
                        37,
                        '2020-01-09',
                        '2020-01-19',
                        'Pending',
                        4,
                        NULL
                    );

INSERT INTO [ORDER] (
                        Order_ID,
                        P_Email,
                        Seller_ID,
                        Inventory_ID,
                        Date,
                        ETA,
                        Status,
                        Copies,
                        Price
                    )
                    VALUES (
                        20,
                        '40@db.project',
                        20,
                        39,
                        '2020-01-10',
                        '2020-01-20',
                        'Pending',
                        2,
                        NULL
                    );


-- Table: PATRON
CREATE TABLE PATRON (
    P_Email VARCHAR (50) REFERENCES PERSON (P_Email) ON DELETE CASCADE
                                                     ON UPDATE CASCADE
                         PRIMARY KEY,
    Card_ID INTEGER      REFERENCES CARD (Card_ID) ON DELETE CASCADE
);

INSERT INTO PATRON (
                       P_Email,
                       Card_ID
                   )
                   VALUES (
                       '1@db.project',
                       1
                   );

INSERT INTO PATRON (
                       P_Email,
                       Card_ID
                   )
                   VALUES (
                       '2@db.project',
                       2
                   );

INSERT INTO PATRON (
                       P_Email,
                       Card_ID
                   )
                   VALUES (
                       '3@db.project',
                       3
                   );

INSERT INTO PATRON (
                       P_Email,
                       Card_ID
                   )
                   VALUES (
                       '4@db.project',
                       4
                   );

INSERT INTO PATRON (
                       P_Email,
                       Card_ID
                   )
                   VALUES (
                       '5@db.project',
                       5
                   );

INSERT INTO PATRON (
                       P_Email,
                       Card_ID
                   )
                   VALUES (
                       '6@db.project',
                       6
                   );

INSERT INTO PATRON (
                       P_Email,
                       Card_ID
                   )
                   VALUES (
                       '7@db.project',
                       7
                   );

INSERT INTO PATRON (
                       P_Email,
                       Card_ID
                   )
                   VALUES (
                       '8@db.project',
                       8
                   );

INSERT INTO PATRON (
                       P_Email,
                       Card_ID
                   )
                   VALUES (
                       '9@db.project',
                       9
                   );

INSERT INTO PATRON (
                       P_Email,
                       Card_ID
                   )
                   VALUES (
                       '10@db.project',
                       10
                   );

INSERT INTO PATRON (
                       P_Email,
                       Card_ID
                   )
                   VALUES (
                       '11@db.project',
                       11
                   );

INSERT INTO PATRON (
                       P_Email,
                       Card_ID
                   )
                   VALUES (
                       '12@db.project',
                       12
                   );

INSERT INTO PATRON (
                       P_Email,
                       Card_ID
                   )
                   VALUES (
                       '13@db.project',
                       13
                   );

INSERT INTO PATRON (
                       P_Email,
                       Card_ID
                   )
                   VALUES (
                       '14@db.project',
                       14
                   );

INSERT INTO PATRON (
                       P_Email,
                       Card_ID
                   )
                   VALUES (
                       '15@db.project',
                       15
                   );

INSERT INTO PATRON (
                       P_Email,
                       Card_ID
                   )
                   VALUES (
                       '16@db.project',
                       16
                   );

INSERT INTO PATRON (
                       P_Email,
                       Card_ID
                   )
                   VALUES (
                       '17@db.project',
                       17
                   );

INSERT INTO PATRON (
                       P_Email,
                       Card_ID
                   )
                   VALUES (
                       '18@db.project',
                       18
                   );

INSERT INTO PATRON (
                       P_Email,
                       Card_ID
                   )
                   VALUES (
                       '19@db.project',
                       19
                   );

INSERT INTO PATRON (
                       P_Email,
                       Card_ID
                   )
                   VALUES (
                       '20@db.project',
                       20
                   );


-- Table: PERSON
CREATE TABLE PERSON (
    P_Email   VARCHAR (50) PRIMARY KEY
                           UNIQUE
                           NOT NULL,
    P_Address VARCHAR (80),
    P_Name    VARCHAR (50) 
);

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '1@db.project',
                       '737 Addison Drive',
                       'Avery'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '2@db.project',
                       '957 Greenview Lane',
                       'Grant'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '3@db.project',
                       '280 Charles St.',
                       'Peter'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '4@db.project',
                       '8710 Glenwood Ave.',
                       'Oscar'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '5@db.project',
                       '11 Hanover Dr.',
                       'Matias'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '6@db.project',
                       '905 Woodsman Rd.',
                       'Amari'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '7@db.project',
                       '9307 Snake Hill Drive',
                       'Andres'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '8@db.project',
                       '940 S. Thompson Street',
                       'Arlo'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '9@db.project',
                       '36 Peninsula Drive',
                       'Colt'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '10@db.project',
                       '8899 E. Fairground Lane',
                       'Adonis'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '11@db.project',
                       '52 Howard St.',
                       'Kyrie'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '12@db.project',
                       '8837 Arch Street',
                       'Steven'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '13@db.project',
                       '313 Madison Street',
                       'Felix'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '14@db.project',
                       '66 Bridge Street',
                       'Preston'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '15@db.project',
                       '8950 Oak Meadow Dr.',
                       'Marcus'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '16@db.project',
                       '20 NW. New St.',
                       'Holden'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '17@db.project',
                       '43 Poplar Court',
                       'Emilio'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '18@db.project',
                       '20 West Branch Dr.',
                       'Remington'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '19@db.project',
                       '7328 Albany Ave.',
                       'Jeremy'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '20@db.project',
                       '33 Halifax St.',
                       'Kaleb'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '21@db.project',
                       'Chambersburg, PA 17201',
                       'Brantley'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '22@db.project',
                       'Mount Laurel, NJ 08054',
                       'Bryce'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '23@db.project',
                       'Enfield, CT 06082',
                       'Mark'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '24@db.project',
                       'Collegeville, PA 19426',
                       'Knox'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '25@db.project',
                       'Round Lake, IL 60073',
                       'Israel'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '26@db.project',
                       'Woodside, NY 11377',
                       'Phoenix'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '27@db.project',
                       'Jeffersonville, IN 47130',
                       'Kobe'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '28@db.project',
                       'Voorhees, NJ 08043',
                       'Nash'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '29@db.project',
                       'Hoboken, NJ 07030',
                       'Griffin'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '30@db.project',
                       'Owatonna, MN 55060',
                       'Caden'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '31@db.project',
                       'Greensburg, PA 15601',
                       'Kenneth'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '32@db.project',
                       'Bayside, NY 11361',
                       'Kyler'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '33@db.project',
                       'Deerfield Beach, FL 33442',
                       'Hayes'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '34@db.project',
                       'Clifton Park, NY 12065',
                       'Jax'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '35@db.project',
                       'East Meadow, NY 11554',
                       'Rafael'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '36@db.project',
                       'Chaska, MN 55318',
                       'Beckham'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '37@db.project',
                       'Fair Lawn, NJ 07410',
                       'Javier'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '38@db.project',
                       'Wooster, OH 44691',
                       'Maximus'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '39@db.project',
                       'San Jose, CA 95127',
                       'Simon'
                   );

INSERT INTO PERSON (
                       P_Email,
                       P_Address,
                       P_Name
                   )
                   VALUES (
                       '40@db.project',
                       'Barberton, OH 44203',
                       'Paul'
                   );


-- Table: SEASON
CREATE TABLE SEASON (
    Inventory_ID  INTEGER REFERENCES TV_SHOW (Inventory_ID) ON DELETE CASCADE,
    Season_Number INTEGER,
    Season_Year   INTEGER,
    PRIMARY KEY (
        Inventory_ID,
        Season_Number
    )
);


-- Table: SELLER
CREATE TABLE SELLER (
    Seller_ID INTEGER      PRIMARY KEY
                           UNIQUE
                           NOT NULL,
    Name      VARCHAR (50) 
);

INSERT INTO SELLER (
                       Seller_ID,
                       Name
                   )
                   VALUES (
                       1,
                       'Seller1'
                   );

INSERT INTO SELLER (
                       Seller_ID,
                       Name
                   )
                   VALUES (
                       2,
                       'Seller2'
                   );

INSERT INTO SELLER (
                       Seller_ID,
                       Name
                   )
                   VALUES (
                       3,
                       'Seller3'
                   );

INSERT INTO SELLER (
                       Seller_ID,
                       Name
                   )
                   VALUES (
                       4,
                       'Seller4'
                   );

INSERT INTO SELLER (
                       Seller_ID,
                       Name
                   )
                   VALUES (
                       5,
                       'Seller5'
                   );

INSERT INTO SELLER (
                       Seller_ID,
                       Name
                   )
                   VALUES (
                       6,
                       'Seller6'
                   );

INSERT INTO SELLER (
                       Seller_ID,
                       Name
                   )
                   VALUES (
                       7,
                       'Seller7'
                   );

INSERT INTO SELLER (
                       Seller_ID,
                       Name
                   )
                   VALUES (
                       8,
                       'Seller8'
                   );

INSERT INTO SELLER (
                       Seller_ID,
                       Name
                   )
                   VALUES (
                       9,
                       'Seller9'
                   );

INSERT INTO SELLER (
                       Seller_ID,
                       Name
                   )
                   VALUES (
                       10,
                       'Seller10'
                   );

INSERT INTO SELLER (
                       Seller_ID,
                       Name
                   )
                   VALUES (
                       11,
                       'Seller11'
                   );

INSERT INTO SELLER (
                       Seller_ID,
                       Name
                   )
                   VALUES (
                       12,
                       'Seller12'
                   );

INSERT INTO SELLER (
                       Seller_ID,
                       Name
                   )
                   VALUES (
                       13,
                       'Seller13'
                   );

INSERT INTO SELLER (
                       Seller_ID,
                       Name
                   )
                   VALUES (
                       14,
                       'Seller14'
                   );

INSERT INTO SELLER (
                       Seller_ID,
                       Name
                   )
                   VALUES (
                       15,
                       'Seller15'
                   );

INSERT INTO SELLER (
                       Seller_ID,
                       Name
                   )
                   VALUES (
                       16,
                       'Seller16'
                   );

INSERT INTO SELLER (
                       Seller_ID,
                       Name
                   )
                   VALUES (
                       17,
                       'Seller17'
                   );

INSERT INTO SELLER (
                       Seller_ID,
                       Name
                   )
                   VALUES (
                       18,
                       'Seller18'
                   );

INSERT INTO SELLER (
                       Seller_ID,
                       Name
                   )
                   VALUES (
                       19,
                       'Seller19'
                   );

INSERT INTO SELLER (
                       Seller_ID,
                       Name
                   )
                   VALUES (
                       20,
                       'Seller20'
                   );


-- Table: STAFF
CREATE TABLE STAFF (
    P_Email               VARCHAR (50) PRIMARY KEY
                                       REFERENCES PERSON (P_Email) ON DELETE CASCADE
                                                                   ON UPDATE CASCADE,
    Staff_Salted_Password VARCHAR (50),
    Staff_Username        VARCHAR (50) UNIQUE
);

INSERT INTO STAFF (
                      P_Email,
                      Staff_Salted_Password,
                      Staff_Username
                  )
                  VALUES (
                      '21@db.project',
                      'password',
                      '21'
                  );

INSERT INTO STAFF (
                      P_Email,
                      Staff_Salted_Password,
                      Staff_Username
                  )
                  VALUES (
                      '22@db.project',
                      'password',
                      '22'
                  );

INSERT INTO STAFF (
                      P_Email,
                      Staff_Salted_Password,
                      Staff_Username
                  )
                  VALUES (
                      '23@db.project',
                      'password',
                      '23'
                  );

INSERT INTO STAFF (
                      P_Email,
                      Staff_Salted_Password,
                      Staff_Username
                  )
                  VALUES (
                      '24@db.project',
                      'password',
                      '24'
                  );

INSERT INTO STAFF (
                      P_Email,
                      Staff_Salted_Password,
                      Staff_Username
                  )
                  VALUES (
                      '25@db.project',
                      'password',
                      '25'
                  );

INSERT INTO STAFF (
                      P_Email,
                      Staff_Salted_Password,
                      Staff_Username
                  )
                  VALUES (
                      '26@db.project',
                      'password',
                      '26'
                  );

INSERT INTO STAFF (
                      P_Email,
                      Staff_Salted_Password,
                      Staff_Username
                  )
                  VALUES (
                      '27@db.project',
                      'password',
                      '27'
                  );

INSERT INTO STAFF (
                      P_Email,
                      Staff_Salted_Password,
                      Staff_Username
                  )
                  VALUES (
                      '28@db.project',
                      'password',
                      '28'
                  );

INSERT INTO STAFF (
                      P_Email,
                      Staff_Salted_Password,
                      Staff_Username
                  )
                  VALUES (
                      '29@db.project',
                      'password',
                      '29'
                  );

INSERT INTO STAFF (
                      P_Email,
                      Staff_Salted_Password,
                      Staff_Username
                  )
                  VALUES (
                      '30@db.project',
                      'password',
                      '30'
                  );

INSERT INTO STAFF (
                      P_Email,
                      Staff_Salted_Password,
                      Staff_Username
                  )
                  VALUES (
                      '31@db.project',
                      'password',
                      '31'
                  );

INSERT INTO STAFF (
                      P_Email,
                      Staff_Salted_Password,
                      Staff_Username
                  )
                  VALUES (
                      '32@db.project',
                      'password',
                      '32'
                  );

INSERT INTO STAFF (
                      P_Email,
                      Staff_Salted_Password,
                      Staff_Username
                  )
                  VALUES (
                      '33@db.project',
                      'password',
                      '33'
                  );

INSERT INTO STAFF (
                      P_Email,
                      Staff_Salted_Password,
                      Staff_Username
                  )
                  VALUES (
                      '34@db.project',
                      'password',
                      '34'
                  );

INSERT INTO STAFF (
                      P_Email,
                      Staff_Salted_Password,
                      Staff_Username
                  )
                  VALUES (
                      '35@db.project',
                      'password',
                      '35'
                  );

INSERT INTO STAFF (
                      P_Email,
                      Staff_Salted_Password,
                      Staff_Username
                  )
                  VALUES (
                      '36@db.project',
                      'password',
                      '36'
                  );

INSERT INTO STAFF (
                      P_Email,
                      Staff_Salted_Password,
                      Staff_Username
                  )
                  VALUES (
                      '37@db.project',
                      'password',
                      '37'
                  );

INSERT INTO STAFF (
                      P_Email,
                      Staff_Salted_Password,
                      Staff_Username
                  )
                  VALUES (
                      '38@db.project',
                      'password',
                      '38'
                  );

INSERT INTO STAFF (
                      P_Email,
                      Staff_Salted_Password,
                      Staff_Username
                  )
                  VALUES (
                      '39@db.project',
                      'password',
                      '39'
                  );

INSERT INTO STAFF (
                      P_Email,
                      Staff_Salted_Password,
                      Staff_Username
                  )
                  VALUES (
                      '40@db.project',
                      'password',
                      '40'
                  );


-- Table: STARS
CREATE TABLE STARS (
    Inventory_ID INTEGER      PRIMARY KEY
                              REFERENCES INVENTORY_ITEM (Inventory_ID) ON DELETE CASCADE,
    Actor_ID     INTEGER      REFERENCES ACTOR (Actor_ID) ON DELETE CASCADE,
    Role         VARCHAR (50) 
);

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      41,
                      1,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      42,
                      2,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      43,
                      3,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      44,
                      4,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      45,
                      5,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      46,
                      6,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      47,
                      7,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      48,
                      8,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      49,
                      9,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      50,
                      10,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      51,
                      11,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      52,
                      12,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      53,
                      13,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      54,
                      14,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      55,
                      15,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      56,
                      16,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      57,
                      17,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      58,
                      18,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      59,
                      19,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      60,
                      20,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      61,
                      1,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      62,
                      2,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      63,
                      3,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      64,
                      4,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      65,
                      5,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      66,
                      6,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      67,
                      7,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      68,
                      8,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      69,
                      9,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      70,
                      10,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      71,
                      11,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      72,
                      12,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      73,
                      13,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      74,
                      14,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      75,
                      15,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      76,
                      16,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      77,
                      17,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      78,
                      18,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      79,
                      19,
                      'Main'
                  );

INSERT INTO STARS (
                      Inventory_ID,
                      Actor_ID,
                      Role
                  )
                  VALUES (
                      80,
                      20,
                      'Main'
                  );


-- Table: TRACK
CREATE TABLE TRACK (
    Inventory_ID INTEGER      REFERENCES INVENTORY_ITEM (Inventory_ID) ON DELETE CASCADE,
    Artist_ID    INTEGER      REFERENCES ARTIST (Artist_ID) ON DELETE SET NULL,
    Name         VARCHAR (50),
    Year         INTEGER,
    Length       INTEGER,
    PRIMARY KEY (
        Inventory_ID,
        Name
    )
);


-- Table: TV_SHOW
CREATE TABLE TV_SHOW (
    Inventory_ID INTEGER      PRIMARY KEY
                              REFERENCES INVENTORY_ITEM (Inventory_ID) ON DELETE CASCADE,
    Name         VARCHAR (50),
    Year         INTEGER,
    Rating       VARCHAR (50) 
);

INSERT INTO TV_SHOW (
                        Inventory_ID,
                        Name,
                        Year,
                        Rating
                    )
                    VALUES (
                        61,
                        'TVShow61',
                        2000,
                        'G'
                    );

INSERT INTO TV_SHOW (
                        Inventory_ID,
                        Name,
                        Year,
                        Rating
                    )
                    VALUES (
                        62,
                        'TVShow62',
                        2001,
                        'PG'
                    );

INSERT INTO TV_SHOW (
                        Inventory_ID,
                        Name,
                        Year,
                        Rating
                    )
                    VALUES (
                        63,
                        'TVShow63',
                        2002,
                        'PG-13'
                    );

INSERT INTO TV_SHOW (
                        Inventory_ID,
                        Name,
                        Year,
                        Rating
                    )
                    VALUES (
                        64,
                        'TVShow64',
                        2003,
                        'R'
                    );

INSERT INTO TV_SHOW (
                        Inventory_ID,
                        Name,
                        Year,
                        Rating
                    )
                    VALUES (
                        65,
                        'TVShow65',
                        2004,
                        'NC-17'
                    );

INSERT INTO TV_SHOW (
                        Inventory_ID,
                        Name,
                        Year,
                        Rating
                    )
                    VALUES (
                        66,
                        'TVShow66',
                        2005,
                        'G'
                    );

INSERT INTO TV_SHOW (
                        Inventory_ID,
                        Name,
                        Year,
                        Rating
                    )
                    VALUES (
                        67,
                        'TVShow67',
                        2006,
                        'PG'
                    );

INSERT INTO TV_SHOW (
                        Inventory_ID,
                        Name,
                        Year,
                        Rating
                    )
                    VALUES (
                        68,
                        'TVShow68',
                        2007,
                        'PG-13'
                    );

INSERT INTO TV_SHOW (
                        Inventory_ID,
                        Name,
                        Year,
                        Rating
                    )
                    VALUES (
                        69,
                        'TVShow69',
                        2008,
                        'R'
                    );

INSERT INTO TV_SHOW (
                        Inventory_ID,
                        Name,
                        Year,
                        Rating
                    )
                    VALUES (
                        70,
                        'TVShow70',
                        2009,
                        'NC-17'
                    );

INSERT INTO TV_SHOW (
                        Inventory_ID,
                        Name,
                        Year,
                        Rating
                    )
                    VALUES (
                        71,
                        'TVShow71',
                        2000,
                        'G'
                    );

INSERT INTO TV_SHOW (
                        Inventory_ID,
                        Name,
                        Year,
                        Rating
                    )
                    VALUES (
                        72,
                        'TVShow72',
                        2001,
                        'PG'
                    );

INSERT INTO TV_SHOW (
                        Inventory_ID,
                        Name,
                        Year,
                        Rating
                    )
                    VALUES (
                        73,
                        'TVShow73',
                        2002,
                        'PG-13'
                    );

INSERT INTO TV_SHOW (
                        Inventory_ID,
                        Name,
                        Year,
                        Rating
                    )
                    VALUES (
                        74,
                        'TVShow74',
                        2003,
                        'R'
                    );

INSERT INTO TV_SHOW (
                        Inventory_ID,
                        Name,
                        Year,
                        Rating
                    )
                    VALUES (
                        75,
                        'TVShow75',
                        2004,
                        'NC-17'
                    );

INSERT INTO TV_SHOW (
                        Inventory_ID,
                        Name,
                        Year,
                        Rating
                    )
                    VALUES (
                        76,
                        'TVShow76',
                        2005,
                        'G'
                    );

INSERT INTO TV_SHOW (
                        Inventory_ID,
                        Name,
                        Year,
                        Rating
                    )
                    VALUES (
                        77,
                        'TVShow77',
                        2006,
                        'PG'
                    );

INSERT INTO TV_SHOW (
                        Inventory_ID,
                        Name,
                        Year,
                        Rating
                    )
                    VALUES (
                        78,
                        'TVShow78',
                        2007,
                        'PG-13'
                    );

INSERT INTO TV_SHOW (
                        Inventory_ID,
                        Name,
                        Year,
                        Rating
                    )
                    VALUES (
                        79,
                        'TVShow79',
                        2008,
                        'R'
                    );

INSERT INTO TV_SHOW (
                        Inventory_ID,
                        Name,
                        Year,
                        Rating
                    )
                    VALUES (
                        80,
                        'TVShow80',
                        2009,
                        'NC-17'
                    );


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
