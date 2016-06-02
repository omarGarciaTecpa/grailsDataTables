<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>
	</head>
	<body>
        <h1>Data Tables</h1>

        <div class="table-responsive">
            <table id="data-list" class="table table-bordered table-hover table-striped" width="100%">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Apellido Paterno</th>
                    <th>Apellido Materno</th>
                </tr>
                </thead>
                <tbody></tbody>
                <tfoot></tfoot>
            </table>
        </div>

        <asset:script>
            (function($){
                $(document).ready(function(){
                    $.get("${createLink(controller: 'person', action: 'list')}", function(data){
                        console.log(data);
                    });

                    $('#data-list').DataTable( {
                        ajax: {
                            url: "${createLink(controller: 'person', action: 'list')}",
                            dataSrc: 'itemList'
                        },
                        "serverSide": true,
                        columns: [
                        { data: 'id' },
                        {data: 'nombre'},
                        {data: 'paterno'},
                        {data: 'materno'}
                        ]
                    } );
                });
            })(jQuery);
        </asset:script>


	</body>
</html>
