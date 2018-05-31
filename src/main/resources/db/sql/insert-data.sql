INSERT INTO Employee
  VALUES  ('67222843543', 'qwerty', 'Maciej', 'Wros', 'intern', '534132652', 'maciej@wros.pl', 1200);
INSERT INTO Employee
  VALUES  ('42314216372', 'lubieProzy', 'Michal', 'Miro', 'receptionist', '700300400', 'michal@miro.pl', 3500);
INSERT INTO Employee
  VALUES  ('75483953623', 'nieZdalemAna1', 'Agnieszka', 'Moj', 'receptionist', '526612413', 'agnieszka@moj.pl', 3000);
INSERT INTO Employee
  VALUES  ('98435593245', 'lubieDisco', 'Agata', 'Mareczek', 'intern', '432414555', 'agata@mareczek.pl', 1450);
INSERT INTO Employee
  VALUES  ('45327272721', 'Burek$!%', 'Bartlomiej', 'Seweryn', 'manager', '321515888', 'bartlomiej@seweryn.pl', 14500);
INSERT INTO Employee
  VALUES  ('87498243474', 'JestemZRadomia', 'Duafi', 'Gib', 'intern', '125777437', 'duafi@gib.com', 420);
INSERT INTO Employee
  VALUES  ('87456345975', 'Zenon1975', 'Slawomir', 'Presley', 'receptionist', '627214574', 'slawomir@presley.com', 2000);
INSERT INTO Employee
  VALUES  ('76964280987', 'kochamDude', 'Wieslawa', 'Black', 'manager', '241555114', 'wieslawa@black.pl', 11000);


INSERT INTO Client
  VALUES  ('marekelko', 'haslo1', 'Staszek', 'Wiosna', '534132652', 'siala@fs.cd');
INSERT INTO Client
  VALUES  ('Mateusz', 'mojpin2', 'Mateusz', 'Szachewicz', '070030040', 'brabrum@ffa.cd');
INSERT INTO Client
  VALUES  ('mirek321', 'pass2', 'Jakub', 'Noskiewicz', '214353221', 'raczka21@afa.gs');
INSERT INTO Client
  VALUES  ('wpustyniityle', 'password4', 'Jakub', 'Sluszny', '153523221', 'misiu33@gf.jk');
INSERT INTO Client
  VALUES  ('elkowicz13', '1pro2myk', 'Baltazar', 'Slytheryn', '231534111', 'fdgvdsn@tw.pl');
INSERT INTO Client
  VALUES  ('eltonjohn', 'ptakiptaki', 'Ebenezer', 'Scrooge', '999352321', 'lalama@ala.com');


INSERT INTO Room (roomNumber, price, size)
  VALUES  (1, 120, 1);
INSERT INTO Room
  VALUES  (2, 220, 2);
INSERT INTO Room
  VALUES  (3, 230, 2);
INSERT INTO Room
  VALUES  (4, 220, 2);
INSERT INTO Room
  VALUES  (5, 320, 3);
INSERT INTO Room
  VALUES  (6, 110, 1);
INSERT INTO Room
  VALUES  (7, 120, 1);
INSERT INTO Room
  VALUES  (8, 300, 2);


INSERT INTO Reservation (status, cost, firstDay, lastDay, board, Client_login, Room_roomNumber)
  VALUES  ('canceledClient', 280, '2018-03-24', '2018-03-26', false, 'marekelko', 1);
INSERT INTO Reservation (status, cost, firstDay, lastDay, board, Client_login, Room_roomNumber)
  VALUES  ('after', 280, '2018-03-24', '2018-03-26', false, 'marekelko', 2);
INSERT INTO Reservation (status, cost, firstDay, lastDay, board, Client_login, Room_roomNumber)
  VALUES  ('before', 500, '2018-06-21', '2018-06-26', true, 'elkowicz13', 3);
INSERT INTO Reservation (status, cost, firstDay, lastDay, board, Client_login, Room_roomNumber)
  VALUES  ('canceledSystem', 230, '2018-02-20', '2018-02-21', false, 'eltonjohn', 4);
INSERT INTO Reservation (status, cost, firstDay, lastDay, board, Client_login, Room_roomNumber)
  VALUES  ('canceledClient', 350, '2018-03-13', '2018-03-15', false, 'eltonjohn', 4);
INSERT INTO Reservation (status, cost, firstDay, lastDay, board, Client_login, Room_roomNumber)
  VALUES  ('before', 620, '2018-06-04', '2018-06-08', true, 'eltonjohn', 3);
INSERT INTO Reservation (status, cost, firstDay, lastDay, board, Client_login, Room_roomNumber)
  VALUES  ('during', 1400, '2018-05-25', '2018-06-02', true, 'mirek321', 2);
