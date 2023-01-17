<div class="mt-3 mb-3">
    <% if (request.getAttribute("success") != null) {%>
    <div id="success-message" class="alert alert-success alert-dismissable">
        <button type="button" class="close" data-dismiss="alert">&times;</button>
        <strong>¡Éxito!</strong> <%= request.getAttribute("success")%>
    </div>
    <hr>
    <% }%>

    <% if (request.getAttribute("error") != null) {%>
    <div id="error-message" class="alert alert-danger alert-dismissable">
        <button type="button" class="close" data-dismiss="alert">&times;</button>
        <strong>¡Error!</strong> <%= request.getAttribute("error")%>
    </div>
    <hr>
    <% }%>
</div>
