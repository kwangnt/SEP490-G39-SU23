use teachsync;

insert into country(countryName, countryAlias, status)
    value ('Vietnam', 'VN', 'CREATED');
insert into province(countryId, provinceName, provinceAlias, status)
    value (1, 'Hanoi', 'HN', 'CREATED');
insert into city(provinceId, cityName, cityAlias, status)
    value (1, 'Hanoi', 'TP.HN', 'CREATED');
insert into district(cityId, districtName, districtAlias, status)
    value (1, 'Ba Dinh', 'Q.Ba Dinh', 'CREATED');
insert into ward(districtId, wardName, wardAlias, status)
    value (1, 'Doi Can', 'P.Doi Can', 'CREATED');
insert into address(countryId, provinceId, cityId, districtId, wardId, areaId, street, addressNo, addressString, status)
values
    (1, 1, 1, 1, 1, null, 'Doi Can', '190ABC', '190ABC Doi Can, P.Doi Can, Q.Ba Dinh, TP.HN, HN, VN', 'CREATED'),
    (1, 1, 1, 1, 1, null, 'Doi Can', '210ABC', '210ABC Doi Can, P.Doi Can, Q.Ba Dinh, TP.HN, HN, VN', 'CREATED');

insert into center(addressId, centerName, centerType, centerDesc, centerSize, status)
    value (1, 'TeachSync Doi Can', 'ENGLISH', null, 20, 'CREATED');

insert into room(centerId, roomType, roomDesc, roomName, roomSize, status)
values
    (1, 'CLASSROOM', null, '101', 30, 'CREATED'),
    (1, 'CLASSROOM', null, '102', 20, 'CREATED'),
    (1, 'CLASSROOM', null, '103', 20, 'CREATED'),
    (1, 'CLASSROOM', null, '104', 40, 'CREATED'),
    (1, 'CLASSROOM', null, '105', 30, 'CREATED');

insert into role(roleName, roleDesc, status)
values
    ('Student', 'Student', 'CREATED'),
    ('Parent', 'Parent', 'CREATED'),
    ('Teacher', 'Teacher', 'CREATED'),
    ('Admin', 'Admin', 'CREATED');

insert into user(username, password, roleId, userAvatar, fullName, email,
                 phone, addressId, resetPasswordToken, parentId, status)
values
    ('student', '$2a$10$2muXk6hqYaoTLnXWCszDaeDE71FGa2hJkh3QPaGKJLRJ77bm6GFJW', 1, null, 'Test Student', 'test.student@gmail.com', null, null, null, null, 'CREATED'),
    ('parent', '$2a$10$2muXk6hqYaoTLnXWCszDaeDE71FGa2hJkh3QPaGKJLRJ77bm6GFJW', 2, null, 'Test Parent', 'test.parent@gmail.com', null, null, null, null, 'CREATED'),
    ('teacher', '$2a$10$2muXk6hqYaoTLnXWCszDaeDE71FGa2hJkh3QPaGKJLRJ77bm6GFJW', 3, null, 'Test Teacher', 'test.teacher@gmail.com', null, null, null, null, 'CREATED'),
    ('admin', '$2a$10$2muXk6hqYaoTLnXWCszDaeDE71FGa2hJkh3QPaGKJLRJ77bm6GFJW', 4, null, 'Test Admin', 'test.admin@gmail.com', null, null, null, null, 'CREATED');
--     Password = 123456789
insert into semester(semesterName, semesterAlias, semesterDesc, semesterType, startDate, endDate, status)
values
    ('Spring 23','SP23','Spring 23', 'SEASON', '2023-01-05', '2023-03-05', 'CREATED'),
    ('Summer 23','SU23','Summer 23', 'SEASON', '2023-03-10', '2023-06-10', 'CREATED'),
    ('Fall 23', 'FA23', 'Fall 23', 'SEASON', '2023-06-15', '2023-09-15', 'CREATED'),
    ('Winter 23', 'WI23', 'Winter 23', 'SEASON', '2023-09-15', '2023-12-15', 'CREATED');

insert into course(courseName, courseAlias, courseImg, courseDesc, numSession, minScore, minAttendant, status)
    value
    ('ielts 101', 'ILT101', 'https://th.bing.com/th/id/OIP.R7Wj-CVruj2Gcx-MmaxmZAHaKe?pid=ImgDet&rs=1', null, 14, 5.0, 80, 'CREATED'),
    ('English Grade 1', 'ENG001', 'https://th.bing.com/th/id/OIP.isjamm3juJANzM_sHKCx0wHaKe?pid=ImgDet&rs=1', null, 12, 4.5, 75, 'CREATED'),
    ('English Grade 2', 'ENG002', 'https://www.geo.tv/assets/uploads/updates/2021-05-03/348462_790220_updates.jpg', null, 12, 5.0, 75, 'CREATED'),
    ('English Grade 3', 'ENG003', 'https://th.bing.com/th/id/OIP.H1Q3_d4okF70VIVYp-YA5AAAAA?pid=ImgDet&w=360&h=470&rs=1', null, 12, 5.0, 75, 'CREATED');

insert into course_semester(courseId, semesterId, centerId, status)
values
    (1, 1, 1, 'CREATED'),
    (1, 2, 1, 'CREATED'),
    (1, 3, 1, 'CREATED'),
    (1, 4, 1, 'CREATED'),
    (2, 1, 1, 'CREATED'),
    (2, 2, 1, 'CREATED'),
    (2, 3, 1, 'CREATED'),
    (2, 4, 1, 'CREATED'),
    (3, 1, 1, 'CREATED'),
    (3, 2, 1, 'CREATED'),
    (3, 3, 1, 'CREATED'),
    (3, 4, 1, 'CREATED'),
    (4, 1, 1, 'CREATED'),
    (4, 2, 1, 'CREATED'),
    (4, 3, 1, 'CREATED');
insert into price_log(courseId, price, isCurrent, isPromotion, promotionAmount,
                      promotionType, promotionDesc, validFrom, validTo, status)
values
    (1, 200000, true, true, 15, 'PERCENT', 'Grand opening super deal, now cheaper ', '2023-06-10 00:00:01', null, 'CREATED'),
    (2, 100000, true, true, 20000, 'AMOUNT', 'To help with the first step, now reduce', '2023-06-10 00:00:01', null, 'CREATED'),
    (3, 125000, true, false, null, null, null, '2023-06-10 00:00:01', null, 'CREATED'),
    (4, 150000, true, false, null, null, null, '2023-06-10 00:00:01', null, 'CREATED');

insert into certificate(courseId, certificateName, certificateDesc, status)
values
    (1, 'Ielts 101', 'You have complete the Ielts 101 course', 'CREATED'),
    (2, 'Eng 1', 'You have complete the Eng 1 course', 'CREATED'),
    (3, 'Eng 2', 'You have complete the Eng 2 course', 'CREATED'),
    (4, 'Eng 3', 'You have complete the Eng 3 course', 'CREATED');

insert into clazz(courseSemesterId, clazzName, clazzDesc, clazzSize, status)
    value
    (1, 'Class 1 Ielts 101', null, 15, 'CREATED'),
    (2, 'Class 2 Ielts 101', null, 15, 'CREATED'),

    (3, 'Class 1 Eng gr 1', null, 30, 'CREATED'),
    (4, 'Class 2 Eng gr 1', null, 30, 'CREATED'),

    (5, 'Class 1 Eng gr 2', null, 30, 'CREATED'),
    (6, 'Class 2 Eng gr 2', null, 30, 'CREATED'),

    (7, 'Class 1 Eng gr 3', null, 25, 'CREATED'),
    (8, 'Class 2 Eng gr 3', null, 25, 'CREATED');

insert into clazz_schedule(clazzId, roomId, scheduleType, startDate, endDate, slot, sessionStart, sessionEnd, status)
values
    (1, 1, 'MON_WED_FRI', '2023-06-10', '2023-08-10', 1, '07:00:00', '08:30:00', 'CREATED'),
    (2, 3, 'TUE_THU_SAT', '2023-06-10', '2023-08-10', 3, '10:30:00', '12:00:00', 'CREATED');

insert into session (roomId, scheduleId, teacherId, slot, sessionStart, sessionEnd, status)
values
    (1, 1, 3, 1, '2023-06-12 07:00:00', '2023-06-12 08:30:00', 'CREATED'),
    (1, 1, 3, 1, '2023-06-14 07:00:00', '2023-06-14 08:30:00', 'CREATED'),
    (1, 1, 3, 1, '2023-06-16 07:00:00', '2023-06-16 08:30:00', 'CREATED'),
    (1, 1, 3, 1, '2023-06-19 07:00:00', '2023-06-19 08:30:00', 'CREATED'),
    (1, 1, 3, 1, '2023-06-21 07:00:00', '2023-06-21 08:30:00', 'CREATED'),
    (1, 1, 3, 1, '2023-06-23 07:00:00', '2023-06-23 08:30:00', 'CREATED'),
    (1, 1, 3, 1, '2023-06-26 07:00:00', '2023-06-26 08:30:00', 'CREATED'),
    (1, 1, 3, 1, '2023-06-28 07:00:00', '2023-06-28 08:30:00', 'CREATED'),
    (1, 1, 3, 1, '2023-06-30 07:00:00', '2023-06-30 08:30:00', 'CREATED'),
    (1, 1, 3, 1, '2023-07-03 07:00:00', '2023-07-03 08:30:00', 'CREATED'),
    (1, 1, 3, 1, '2023-07-05 07:00:00', '2023-07-05 08:30:00', 'CREATED'),
    (1, 1, 3, 1, '2023-07-07 07:00:00', '2023-07-07 08:30:00', 'CREATED');