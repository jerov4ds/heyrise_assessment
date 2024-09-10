Tables
Calendar Table:

id (Primary Key): Unique identifier for the calendar.
name: Name of the calendar.
Booking Table:

id (Primary Key): Unique identifier for the booking.
date: Date of the booking.
start_time: Start time of the booking.
end_time: End time of the booking.
calendar_id (Foreign Key): Reference to the Calendar table.
Relationships
One-to-Many Relationship: A single Calendar can have multiple Bookings.
Many-to-One Relationship: Each Booking belongs to a specific Calendar.


###Entity-Relationship Diagram (ERD)
#####Entities:

Calendar (Entity)
id (PK)
name
Booking (Entity)
id (PK)
date
start_time
end_time
calendar_id (FK to Calendar)
Relationships:

Calendar 1--∞ Booking (A calendar can have many bookings)
ERD Layout
Calendar (id, name)

id (Primary Key)
name
↓ (One-to-Many relationship)

Booking (id, date, start_time, end_time, calendar_id)

id (Primary Key)
date
start_time
end_time
calendar_id (Foreign Key, references Calendar.id)
