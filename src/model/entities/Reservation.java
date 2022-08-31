package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
	}
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public Date getCheckIn() {
		return checkIn;
	}
	
	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		//Diff vai me retornar a diferença entre as datas em milisegundos.
		long diff = checkOut.getTime() - checkIn.getTime();
		//Com o TimeUnit faz a conversão de milisegundos para dias.
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
	}
	
	public String updateDate(Date checkIn, Date checkOut) {
		Date agora = new Date();
		
		if (checkIn.before(agora) || checkOut.before(agora)) {
			return "As novas datas tem que ser futuras!";
		}
		if(!checkOut.after(checkIn)){
			return "A data de check-out tem que ser pos check-in!";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		return null;
	}
	
	@Override
	public String toString() {
		return "QUARTO: "+ roomNumber +", CheckIn: "+
				sdf.format(checkIn)+", checkOut: "+
				sdf.format(checkOut) + ", "+duration()+" noites.";
	}
}
