CREATE TABLE public.patient (
    id SERIAL PRIMARY KEY,
    patient_id UUID NOT NULL UNIQUE,
    name VARCHAR(100),
    last_name VARCHAR(100),
    second_last_name VARCHAR(100),
    active ENUM(0, 1) DEFAULT 1,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP  NOT NULL
);
CREATE INDEX IF NOT EXISTS name_index ON public.patient(name);


CREATE TABLE public.medic (
    id SERIAL PRIMARY KEY,
    medic_id UUID NOT NULL UNIQUE,
    name VARCHAR(100),
    last_name VARCHAR(100),
    second_last_name VARCHAR(100),
    specialty VARCHAR(100),
    active ENUM(0, 1) DEFAULT 1,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP  NOT NULL
);
CREATE INDEX IF NOT EXISTS name_specialty_index ON public.medic(name, specialty);

CREATE TABLE public.medical_office (
    id SERIAL PRIMARY KEY,
    medical_office_id UUID NOT NULL UNIQUE,
    number INT NOT NULL,
    floor INT NOT NULL,
    active ENUM(0, 1) DEFAULT 1,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP  NOT NULL
);

CREATE TABLE public.care (
    id SERIAL PRIMARY KEY,
    patient_id UUID NOT NULL,
    medic_id UUID NOT NULL,
    medical_office_id UUID NOT NULL,
    attention_date TIMESTAMP NOT NULL,
    active ENUM(0, 1) DEFAULT 1,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP  NOT NULL,
    CONSTRAINT FK_PATIENT
        FOREIGN KEY (patient_id)
        REFERENCES patient(patient_id),
    CONSTRAINT FK_MEDIC
            FOREIGN KEY (medic_id)
            REFERENCES medic(medic_id),
    CONSTRAINT FK_MEDICAL_OFFICE
                FOREIGN KEY (medical_office_id)
                REFERENCES medical_office(medical_office_id)
);
CREATE INDEX IF NOT EXISTS patient_id_medic_id_medical_office_id_index ON public.care(patient_id,medic_id,medical_office_id);