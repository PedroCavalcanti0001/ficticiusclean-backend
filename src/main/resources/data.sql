create table VEHICLE
(
    id                                  bigint generated by default as identity,
    average_consumption_in_the_city     decimal(19, 2),
    average_consumption_in_the_highways decimal(19, 2),
    brand                               varchar(255),
    manufacturing_year                  integer not null,
    model                               varchar(255),
    name                                varchar(255),
    primary key (id)
);

INSERT INTO VEHICLE(average_consumption_in_the_city,
                    average_consumption_in_the_highways,
                    brand,
                    manufacturing_year,
                    model,
                    name)
VALUES (8.5, 10.5, 'CHEVROLET', 2013, 'ONYX', 'ONIX PLUS');


INSERT INTO VEHICLE(average_consumption_in_the_city,
                    average_consumption_in_the_highways,
                    brand,
                    manufacturing_year,
                    model,
                    name)
VALUES (10.0, 10.0, 'CHEVROLET', 2019, 'ONYX', 'ONIX PLUS TESTE');


INSERT INTO VEHICLE(average_consumption_in_the_city,
                    average_consumption_in_the_highways,
                    brand,
                    manufacturing_year,
                    model,
                    name)
VALUES (7.5, 10.0, 'CHEVROLET', 2022, 'WTZ', 'ONIX');

INSERT INTO VEHICLE(average_consumption_in_the_city,
                    average_consumption_in_the_highways,
                    brand,
                    manufacturing_year,
                    model,
                    name)
VALUES (8.0, 9.5, 'ford', 2022, 'WARD', 'FUSION');
