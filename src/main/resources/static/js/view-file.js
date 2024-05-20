$(document).on('click', '.viewFileButton', function() {
    var file = $(this).data('file');

    var mimetype = detectMimeType(file);
    var src = 'data:' + mimetype + ';base64,' + file;

    console.log(src);

    $('#fileTitle').html($(this).data('file-title') != undefined? $(this).data('file-title'):'View File');
    $("#fileViewContainer").html("");
    if (mimetype === "application/pdf")
        $("#fileViewContainer").html('<iframe class="overflow-auto w-100" style="height:85vh;" src="' + src + '" type="application/pdf"></iframe>');
    else if (mimetype === "image/jpg" || mimetype === "image/jpeg" || mimetype === "image/png")
        $("#fileViewContainer").html('<img class="overflow-auto w-100" style="height:85vh;object-fit: contain" src="' + src + '"></img>');
      else
         $("#fileViewContainer").html('File not Uploaded');
    $("#fileViewModal").modal("show");
});

function detectMimeType(data){
    var FileMimeType = {
        "JVBER": "application/pdf",
        "/9J/2": "image/jpg",
        "/9J/4": "image/jpeg",
        "IVBOR": "image/png"
    };
    return FileMimeType[data.toUpperCase().substr(0, 5)];
}