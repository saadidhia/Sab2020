package com.authgoogle.jpa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Calendrier")
public class Calendrier {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
    @Size(max = 65)
    @Column(name = "month")
    private int month;
	
	@NotNull
    @Size(max = 65)
    @Column(name = "day")
    private int day;
	
	@NotNull
    @Size(max = 65)
    @Column(name = "hour")
    private int hour;
	
	@NotNull
    @Size(max = 65)
    @Column(name = "minute")
    private int minute;

	@NotNull
    @Size(max = 65)
    @Column(name = "second")
    private int second;
	
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_collaborateur")
    private List<Calendrier> calendrier;
	
	  public Calendrier () {
	    	
	    }

		public Calendrier(Long id, @NotNull @Size(max = 65) int month, @NotNull @Size(max = 65) int day,
				@NotNull @Size(max = 65) int hour, @NotNull @Size(max = 65) int minute,
				@NotNull @Size(max = 65) int second) {
			super();
			this.id = id;
			this.month = month;
			this.day = day;
			this.hour = hour;
			this.minute = minute;
			this.second = second;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public int getMonth() {
			return month;
		}

		public void setMonth(int month) {
			this.month = month;
		}

		public int getDay() {
			return day;
		}

		public void setDay(int day) {
			this.day = day;
		}

		public int getHour() {
			return hour;
		}

		public void setHour(int hour) {
			this.hour = hour;
		}

		public int getMinute() {
			return minute;
		}

		public void setMinute(int minute) {
			this.minute = minute;
		}

		public int getSecond() {
			return second;
		}

		public void setSecond(int second) {
			this.second = second;
		}
		
}
