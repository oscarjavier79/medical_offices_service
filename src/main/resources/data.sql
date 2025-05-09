--medics--
insert into public.medic (medic_id, name, last_name, second_last_name, specialty, created_at, updated_at)
values ('38229916-5400-11ea-8d77-2e728de09477','Benjamin', 'Hernandez', 'Gutierrez', 'DOCTOR GENERAL', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into public.medic (medic_id, name, last_name, second_last_name, specialty, created_at, updated_at)
values ('38229916-5400-11ea-8d77-2e728de09327','Alan', 'Mendez', 'Mendez', 'DOCTOR GENERAL', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into public.medic (medic_id, name, last_name, second_last_name, specialty, created_at, updated_at)
values ('38229916-5400-11ea-8d77-2e728de09577','Gerardo', 'Martinez', 'Ortiz', 'DOCTOR GENERAL', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
--patients--
insert into public.patient (patient_id, name, last_name, second_last_name, created_at, updated_at)
values ('38229916-5400-11ea-8d77-2e728de09322','Pedro', 'Lopez', 'Martinez', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into public.patient (patient_id, name, last_name, second_last_name,  created_at, updated_at)
values ('38229916-5400-11ea-8d77-2e728de09600','Iris', 'Olivares', 'Ruiz', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into public.patient (patient_id, name, last_name, second_last_name, created_at, updated_at)
values ('38229916-5400-11ea-8d77-2e728de09522','Diego', 'Martinez', 'Alvarez', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
--medical_office--
insert into public.medical_office (medical_office_id, number,floor,created_at, updated_at)
values ('38229916-5400-11ea-8d77-2e728de89744',1,1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into public.medical_office (medical_office_id, number,floor,created_at, updated_at)
values ('38229916-5400-11ea-8d77-2e728de36455',2,2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into public.medical_office (medical_office_id, number,floor,created_at, updated_at)
values ('38229916-5400-11ea-8d77-2e728de14233',3,1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);