# =========================================================================
# 🔹 INSTALL, BUILD ET RUN
# =========================================================================
Apres avoir clone le project, validez ces 2 etapes
1 - lancez la commande : ./gradlew clean build
2 - lancez la commande : ./gradlew bootRun


# =========================================================================
# 🔹 DISPOSITION A L'EGARD DE LA BASE DE DONNES
# =========================================================================
Au lancement du projet le script shema.sql devrait créer les schémas tenant1, tenant2
et tenant3 dans la base de donnees 'grade_demo_db', ansi que les séquences tenant_id_seq sont crées
 verifiez qu'ils bien crees:
SELECT * FROM pg_sequences WHERE schemaname = 'tenant1' AND sequencename = 'tenant_id_seq';


# =========================================================================
# 🔹 LES OPERATIONS CRUD CONCURRENTES
# =========================================================================
# REQUETES POST
via curl ->
curl --location --request POST 'localhost:2025/tenant' \
--header 'X-PrivateTenant: tenant1' \
--header 'Content-Type: application/json' \
--data-raw '{
"name": "Daniel",
"age": 38,
"email": "daniel@gmail.com"
}'

curl --location --request POST 'localhost:2025/tenant' \
--header 'X-PrivateTenant: tenant2' \
--header 'Content-Type: application/json' \
--data-raw '{
"name": "Alice",
"age": 35,
"email": "alice@gmail.com"
}'

curl --location --request POST 'localhost:2025/tenant' \
--header 'X-PrivateTenant: tenant3' \
--header 'Content-Type: application/json' \
--data-raw '{
"name": "Durand",
"age": 32,
"email": "durand@gmail.com"
}'

via postman -> 

# REQUETES GET ALL
via curl ->
curl --location --request GET 'localhost:2025/tenant' \
--header 'X-PrivateTenant: tenant1' \
--header 'Content-Type: application/json' 

# REQUETES GET BY ID![postman1.png](../../../../../../Users/danielstein/Desktop/postman1.png)
via curl ->
curl --location --request GET 'localhost:2025/tenant/1' \
--header 'X-PrivateTenant: tenant1' \
--header 'Content-Type: application/json'