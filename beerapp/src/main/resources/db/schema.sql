CREATE TABLE beer (
  id identity primary key,
  name varchar(100) not null,
  brewery varchar(255),
  genre varchar(50)
);

INSERT INTO beer (name,brewery,genre) VALUES ('Okocim jasne','Okocim','light'),
('Żywiec premium','Żywiec','light'),
('Okocim mocne','Okocim','dark');

