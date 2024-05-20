CREATE TABLE IF NOT EXISTS public.park
(
    id             BIGSERIAL PRIMARY KEY,
    energy_type    VARCHAR(255) NOT NULL,
    capacity       BIGINT NOT NULL
);

ALTER SEQUENCE park_id_seq RESTART 1000 INCREMENT BY 50;

CREATE TABLE IF NOT EXISTS public.time_block
(
    id             BIGSERIAL PRIMARY KEY,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,
    energy_quantity BIGINT NOT NULL,
    price_floor DOUBLE PRECISION NOT NULL
);

ALTER SEQUENCE time_block_id_seq RESTART 1000 INCREMENT BY 50;
CREATE TABLE IF NOT EXISTS public.offer
(
    id             BIGSERIAL PRIMARY KEY,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    market_type VARCHAR(255) NOT NULL
);

ALTER SEQUENCE offer_id_seq RESTART 1000 INCREMENT BY 50;

CREATE TABLE time_block_producer (
    time_block_id BIGINT NOT NULL,
    park_id BIGINT NOT NULL,
    PRIMARY KEY (time_block_id, park_id),
    FOREIGN KEY (time_block_id) REFERENCES time_block (id),
    FOREIGN KEY (park_id) REFERENCES park (id)
);

ALTER TABLE time_block ADD COLUMN offer_id BIGINT;
ALTER TABLE time_block ADD CONSTRAINT fk_time_block_offer FOREIGN KEY (offer_id) REFERENCES offer (id);