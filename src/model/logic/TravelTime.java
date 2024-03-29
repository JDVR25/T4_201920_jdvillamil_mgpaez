package model.logic;

public class TravelTime implements Comparable<TravelTime>
{
	private int idZonaOrigen;

	private int idZonaDestino;

	private int hora_mes_dia;

	private double tiempoPromedioViaje;

	private double desviacionEstandarTiempo;

	private double tiempoGeometricoPromedio;

	private double desviacionEstandarTGeometrico;

	public TravelTime(int sourceID, int dsTID, int hour, double travelTime, double travelTimeDeviation,
			double geometricTime, double geometricDeviation)
	{
		idZonaOrigen = sourceID;

		idZonaDestino = dsTID;

		hora_mes_dia = hour;

		tiempoPromedioViaje = travelTime;

		desviacionEstandarTiempo = travelTimeDeviation;

		tiempoGeometricoPromedio = geometricTime;

		desviacionEstandarTGeometrico = geometricDeviation;
	}

	public int darIDOrigen()
	{
		return idZonaOrigen;
	}

	public int darIdDestino()
	{
		return idZonaDestino;
	}

	public int darHoraOMesODia()
	{
		return hora_mes_dia;
	}

	public double darTiempoViaje()
	{
		return tiempoPromedioViaje;
	}

	public double darDesviacionTiempo()
	{
		return desviacionEstandarTiempo;
	}

	public double darTiempoGeometrico()
	{
		return tiempoGeometricoPromedio;
	}

	public double darDesviacionTGeometrico()
	{
		return desviacionEstandarTGeometrico;
	}

	@Override
	public int compareTo(TravelTime o) {
		int respuesta = 0;
		if(tiempoPromedioViaje > o.darTiempoViaje())
		{
			respuesta = 1;
		}
		else if(tiempoPromedioViaje < o.darTiempoViaje())
		{
			respuesta = -1;
		}
		return respuesta;
	}
}
