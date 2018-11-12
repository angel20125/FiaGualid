<?php
$hostname_localhost ="localhost";
$database_localhost ="app_desarrollo";
$username_localhost ="root";
$password_localhost ="";

$json=array();
$idventas="*";
$idcliente="*";
$idarticulos="*";
$tipo_pago="*";
$serie_comprobante="*";
$nro_comprobante="*";
$fecha_hora="*";
$cantidad="*";
$total_venta="*";
$estado="*";

$consultaPorRealizar=TRUE;

	if( isset($_GET["idventas"]) 	|| isset($_GET["idcliente"]) || 
		isset($_GET["idarticulos"])	|| isset($_GET["tipo_pago"]) || 
		isset($_GET["serie_comprobante"]) || isset($_GET["nro_comprobante"]) || 
		isset($_GET["fecha_hora"])	||	isset($_GET["cantidad"])||isset($_GET["total_venta"])||
		isset($_GET["estado"])&& $consultaPorRealizar)
	{

	
		if(isset($_GET["idventas"])) {
			$idventas=($_GET['idventas']); 
		}

		if(isset($_GET["idcliente"])) { 
			$idcliente=($_GET['idcliente']); 
		}

		if(isset($_GET["idarticulos"])) { 
			$idarticulos=($_GET['idarticulos']); 
		}	
			
		if(isset($_GET["tipo_pago"])) { 
			$tipo_pago=($_GET['tipo_pago']);
		}
		if (isset($_GET["serie_comprobante"])) {
			$serie_comprobante=($_GET['serie_comprobante']);
		}
		if(isset($_GET["nro_comprobante"])){
			$nro_comprobante=($_GET['nro_comprobante']);

		}		
		if(isset($_GET["fecha_hora"])){
			$fecha_hora=($_GET['fecha_hora']);

		}		
		if(isset($_GET["total_venta"])){
			$total_venta=($_GET['total_venta']);
		}

		if(isset($_GET["estado"])){
			$estado=($_GET['estado']);

		}

			$conexion = mysqli_connect($hostname_localhost,$username_localhost,$password_localhost,$database_localhost);

			
		$consulta="SELECT idventas,idcliente,idarticulos,tipo_pago,serie_comprobante,nro_comprobante,fecha_hora,cantidad,total_venta,estado FROM ventas WHERE (idventas LIKE '%".$idventas."%' ) OR (idcliente LIKE '%".$idcliente."%' ) OR (idarticulos LIKE '%".$idarticulos."%' ) OR (tipo_pago LIKE '%".$tipo_pago."%' ) OR (serie_comprobante LIKE '%".$serie_comprobante."%' ) OR (nro_comprobante LIKE '%".$nro_comprobante."%' ) OR (fecha_hora LIKE '%".$fecha_hora."%' ) OR  (cantidad LIKE '%".$cantidad."%' ) OR  (total_venta LIKE '%".$total_venta."%' ) OR (estado LIKE '%".$estado."%' )";
			
			$resultado=mysqli_query($conexion,$consulta) or die("No se pudo conectar");
			
			while($registro=mysqli_fetch_array($resultado)){
				$json['ventas'][]=$registro;
				

			}
			mysqli_close($conexion);
			echo json_encode($json);
			$consultaPorRealizar =FALSE;

	}else{
			

			$resulta["idventas"]=0;
			$resulta["idcliente"]=0;
			$resulta["idarticulos"]=0;
			$resulta["tipo_pago"]='*';
			$resulta["serie_comprobante"]='*';
			$resulta["nro_comprobante"]='*';
			$resulta["fecha_hora"]='*';
			$resulta["cantidad"]=0;
			$resulta["total_venta"]=0;
			$resulta["estado"]='*';
			$json['ventas'][]=$resulta;
			echo json_encode($json);

	

	}
	


?>