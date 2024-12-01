# BeeAware-Service
## App SOAR 2024

### Pollenic Allergy Monitoring Platform
Allergies affect a large portion of the population, and their symptoms can be
exacerbated by various environmental factors, including weather conditions.
The platform's goal is to provide users with a channel for information on
high-risk periods based on daily pollen forecasts to help them anticipate
potential symptoms. Additionally, it will allow users to log their perceived
symptoms daily on a subjective scale so they can compare these symptoms with
the pollen load index. Users can also record days when an antihistamine was
taken to observe its impact on symptoms. All this information will be grouped
in a graph, providing users a simple and effective visualization tool to review
their personal history, helping them act accordingly or discuss with a healthcare
professional. The platform will rely on a Google Pollen API for pollen load
forecasts to retrieve pollen indices based on the user's specified location.

### Getting Started

To use our BeeAware application please download the BeeAware Service Application and
follow the specifications in the `README.md` file

### Core Domain Classes

1. **Beezzer**:
    - Represents a user (Beezzer) in the system, containing personal information
    such as username, email, password, location, and allergens.

2. **Location**:
    - Represents a geographical location, defined by its latitude, longitude, country,
    and NPA code. This class needs the Google Geocoding API service in our BeeAware Service
    to obtain latitude and longitude coordinates based on NPA and country information.

3. **Coordinate**:
    - Handles the retrieval and processing of pollen forecasts with the Google Pollen API.

4. **PasswordUtilis**:
    - Utility class for password-related operations, including hashing, verification, 
    and checking password constraints for strength and validity.
    This class enforces minimum password standards by validating the inclusion of
    uppercase & lowercase letters, numbers, and special characters.

5. **Pollen**:
    - This class represents a type of pollen with a unique ID and a name.
    It also maintains a predefined list of pollens and provides functionalities
    to retrieve them based.

6. **PollenLocationIndex**:
    - Represents an index of pollen charge and related information in a particular location
    and date, constructed based on the PollenLocationInfo class. This class includes details
    such as the pollen name, pollen charge, date, location, health recommendations, and
    potential cross-reactions.

7. **PollenLocationInfo**:
    - Information about pollen for a specific geographical region and date retrived from the
    Google Pollen API.

8. **Role**:
    - Represent a specific role within the beezzers that gives you certain accesses for our API.
   ADMIN is a role that grants access to every resource, BEEZZER is restricted to call for
   only for your unique identifier.

9. **Symptom**:
    - This class represents the details of a symptom experienced by a beezzer.
    It includes information such as the type of reaction, whether antihistamines were used, 
    the date the symptom was entered, and the unique identifier of the beezzer unique identifier.

10. **Credentials**
    - Contains the information used to authenticate a beezzer.

11. **Token**:
    - This class represents a security token used in the application for authentication and authorization purposes.