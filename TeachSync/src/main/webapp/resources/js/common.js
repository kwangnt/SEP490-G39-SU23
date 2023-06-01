function showById(id) {
	$("#" + id).removeClass("visually-hidden");
}

function hideById(id) {
    $("#" + id).addClass("visually-hidden");
}

function copyToClipboard(id) {
    const fadeTime = 1000;

    navigator.clipboard.writeText($("#" + id).text());

    $("body").prepend(
        '<div class="fixed-top d-flex justify-content-center" id="alert">' +
        '   <p class="bg-grey-sub rounded-pill py-2 px-5" style="width: fit-content;">' +
        '       Copied to clipboard' +
        '   </p>' +
        '</div>');

    $("#alert").fadeOut(fadeTime);

    setTimeout(function() { $("#alert").remove(); }, fadeTime);
}