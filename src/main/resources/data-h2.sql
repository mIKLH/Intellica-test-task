INSERT INTO address (id, line1, line2, postcode, town) values
(1, 'Golden Gate str.', null, '03127', 'Kyiv'),
(2, 'Sechenova str.', null, '02425', 'Kyiv');


INSERT INTO task (id, date, first_name, last_name, title, address_id) VALUES
('758811e7-f230-47a5-a5e9-f6bc5413e74d','2019-04-01T09:15:49.455','Eric','Montana','Mr', 1),
('c5e073c5-f10e-4a14-b289-598a891ca837','2019-02-12T11:06:49.455','Salah','Mane','Mr', 2),
('c13d2c10-1122-44e6-b20e-eef96f8b7c27','2019-07-13T12:17:49.455','Van Dijk','Firmino','Mr', null),
('06495a7e-8b07-4c3a-b66c-e14101d1290c','2019-08-10T13:18:49.455','Eric','Cantona','Miss', null),
('a2fa475e-1886-4783-a5c3-054a2ff10031','2018-04-28T16:33:49.455','Cristiano','Messi', 'Mrs', null);


