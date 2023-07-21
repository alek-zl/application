## 1. **activity_splash_screen**
- сделан

## 2. **activity_start_screen** 
- по нажатию "продолжить" -> **activity_registr** (сделано)

## 3. **activity_registr**
- кнопка назад (сделано)
- по нажатию "продолжить", проверка коректнного ввода номера телефона:\
если верно: api/auth/login и выводим "verificationCode" в уведомление и -> **activity_code**\
если не верно: очищаем поля для ввода и ожидаем повторного ввода

## 4. **activity_code**
- кнопка назад (сделано)
- после ввода "verificationCode":\
если верно и ""isUserInBD": true": ЗАПОЛНИ\
если верно и ""isUserInBD": false": то -> **activity_nb****\
если не верно: очищаем поля для ввода цифр и ожидаем повторного ввода

## 4.1. **activity_nb** 
- кнопка назад (сделано)
- при нажатии "завершить регистрацию" отправка запроса api/auth/register:
если:  "statusCode": 400, то очищаем поля и ждем повторного ввода
если:  "statusCode": 200, то -> **activity_menu**





## api/auth/login

### Тело запроса (Request Body):

{\
  "phone": "+79000000000"\
}


- phone (обязательное поле) - номер телефона пользователя в формате "+79xxxxxxxxx".

### Ответы (Responses):

Ответ при успешной аутентификации:

- Код ответа: 200 OK
- Тело ответа (Response Body):

{\
    "isUserInBD": true,\
    "verificationCode": "7285",\
    "accessToken": "FeAOzPHRoHcY4"\
}

Ответ при отсутствии пользователя в базе данных:

- Код ответа: 200 OK
- Тело ответа (Response Body):

{\
    "isUserInBD": false,\
    "verificationCode": "7460"\
}


- isUserInBD - флаг, указывающий, есть ли пользователь с указанным номером телефона в базе данных. Если пользователь существует, значение будет true, в противном случае false.
- verificationCode - код подтверждения/верификации, который будет отправлен на указанный номер телефона.
- accessToken - токен доступа пользователя для последующей авторизации.

## api/auth/register

### Тело запроса (Request Body):

{\
    "phone": "+79000000000",\
    "name": "имя",\
    "gender": "мужской",\
    "dateOfBirth": "11.22.1234"\
}


- phone (обязательное поле) - номер телефона нового пользователя в формате "+79876543210".
- name (обязательное поле) - имя нового пользователя.
- gender (обязательное поле) - пол нового пользователя.
- dateOfBirth (обязательное поле) - дата рождения нового пользователя.

### Ответы (Responses):

Ответ при успешной регистрации:

- Код ответа: 200 OK
- Тело ответа (Response Body):

{\
    "accessToken": "eyJhbGciOiJIUzI1NM4"\
}


- accessToken - токен доступа пользователя для последующей авторизации.

### Package Structure


```
├── appcomponents       
│ ├── di                 - Dependency Injection Components 
│ │ └── MyApp.kt
│ ├── network            - REST API Call setup
│ │ ├── ResponseCode.kt
│ │ └── RetrofitProvider.kt
│ └── ui                 - Data Binding Utilities
│     └── CustomBindingAdapter.kt
├── constants            - Constant Files
│ ├── IntegerConstants.kt
│ └── StringConstants.kt
├── extensions           - Kotlin Extension Function Files
│ └── Strings.kt
├── modules              - Application Specific code
│ └── example            - A module of Application 
│  ├── ui                - UI handling classes
│  └── data              - Data Handling classes
│    ├── viewmodel       - ViewModels for the UI
│    └── model           - Model for the UI
└── network              - REST API setup
  ├── models             - Request/Response Models
  ├── repository         - Network repository
  ├── resources          - Common classes for API
  └── RetrofitService.kt
```
