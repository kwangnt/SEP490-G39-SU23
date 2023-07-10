function openEditCourseSemester(divId, editBtnId, cancelBtnId, saveBtnId) {
    enableAllInputIn(divId, 'checkbox');
    hideById(editBtnId);
    showById(cancelBtnId);
    showById(saveBtnId);
}

function cancelEditCourseSemester(divId, editBtnId, cancelBtnId, saveBtnId) {
    disableAllInputIn(divId, 'checkbox');
    showById(editBtnId);
    hideById(cancelBtnId);
    hideById(saveBtnId);
}

function sendRequestEditCourseSemester(divId) {
    let semesterId = Number(${semesterId});
    let centerId = Number(${centerId});

    let courseIdList = $("#"+divId+" input[type=checkbox]:checked").val();
    courseIdList = courseIdList.map(Number);

    let courseSemester = [];
    for (const courseId of courseIdList) {
        courseSemester.push({
            "semesterId": semesterId,
            "centerId": centerId,
            "courseId": courseId});
    }

    $.post('/semester', courseSemester.serialize());
}