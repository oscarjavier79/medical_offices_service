# Medical Offices

curl --location --request POST 'http://localhost:8085/api/care/create' \
--header 'Content-Type: application/json' \
--data-raw '{
  "messageType": "REQUEST_MESSAGE",
  "transactionID": "e0d09e0f-d84a-4061-b771-422a70ce28da",
  "componentID": "",
  "timestamp": "2022-09-09 09:22:10:00",
  "endpoint": "/care/create",
  "data": [
    {
    "patientId": "38229916-5400-11ea-8d77-2e728de09322",
    "medicId": "38229916-5400-11ea-8d77-2e728de09477",
    "medicalOfficeId": "38229916-5400-11ea-8d77-2e728de89744",
    "attentionDate": "2025-05-09",
    "createdAt": "2025-05-09",
    "updatedAt": "2025-05-09"
    }
]
}


'
