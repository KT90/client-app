CREATE TABLE client (
                        id BIGINT AUTO_INCREMENT,
                        name VARCHAR(50) NOT NULL,
                        agreed_to_terms BOOLEAN NOT NULL
);
CREATE TABLE sector (
                        id BIGINT PRIMARY KEY,
                        name VARCHAR(50) NOT NULL,
                        parent_sector_id BIGINT,
                        foreign key (parent_sector_id) references sector(id)
);

CREATE TABLE client_sector (
                        client_id BIGINT NOT NULL,
                        sector_id BIGINT NOT NULL,
                        foreign key (client_id) references client(id),
                        foreign key (sector_id) references sector(id)
);


