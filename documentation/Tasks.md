| №  | N-task  | Описание задачи                                                                                                                                                    |
|----|---------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1  | 10-task | В классе `TravelCalculatePremiumRequest` создать: дефолтный конструктор, конструктор со всеми свойствами, методы `get`/`set`.                                      |
| 2  | 11-task | В классе `TravelCalculatePremiumResponse` создать: дефолтный конструктор, конструктор со всеми свойствами, методы `get`/`set`.                                     |
| 3  | 12-task | Заполнить поля ответа, значения для заполнения взять из запроса в классе `TravelCalculatePremiumServiceImpl`.                                                      |
| 4  | 13-task | Написать тесты в классе `TravelCalculatePremiumServiceImplTest` на метод `calculatePremium`.                                                                       |
| 5  | 14-task | Изменить класс `TravelCalculatePremiumServiceImplTest`, написать отдельный тестовый метод на каждое поле ответа.                                                   |
| 6  | 16-task | Добавить в ответ (`TravelCalculatePremiumResponse`) свойство `agreementPrice` типа `BigDecimal`.                                                                   |
| 7  | 17-task | заполнить в ответе свойство agreementPrice согласно следующей формуле: agreementPrice = days between agreementDateFrom and agreementDateTo                         |
| 8  | 18-task | если расчёт стоимости из предыдущего шага был реализован внутри метода calculatePremium(), то вынесите код расчета количества дней между датами в отдельный метод. |
| 9  | 19-task | создайте новый класс (DateTimeService) рядом с TravelCalculatePremiumServiceImpl и поместите в него алгоритм расчёта числа дней между двумя датами                 |

