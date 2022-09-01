package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
	}
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException{
		if(!checkOut.after(checkIn)) {
			throw new DomainException("A data de checkout tem que ser depois da data de checkin");
		}
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
	
	public void updateDate(Date checkIn, Date checkOut) throws DomainException{
		Date agora = new Date();
		
		if (checkIn.before(agora) || checkOut.before(agora)) {
			throw new DomainException("As novas datas tem que ser futuras!");
		}
		if(!checkOut.after(checkIn)){
			throw new DomainException("A data de check-out tem que ser pos check-in!");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "QUARTO: "+ roomNumber +", CheckIn: "+
				sdf.format(checkIn)+", checkOut: "+
				sdf.format(checkOut) + ", "+duration()+" noites.";
	}
}
