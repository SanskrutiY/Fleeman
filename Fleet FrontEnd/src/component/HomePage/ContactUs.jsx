// src/components/ContactUs.js
import React from 'react';
import './Contact.css';

const ContactUs = () => {
  return (
    <div className="contact-container">
      <h1>Contact Us</h1>
      <p>If you need assistance, we’re here to help 24/7!</p>

      <div className="contact-section">
        <h3>📞 Emergency Support</h3>
        <p>
          Phone: <a href="tel:+919999999999">+91 99999 99999</a>
        </p>
        <p>
          Email: <a href="mailto:support@fleeman.com">support@fleeman.com</a>
        </p>
      </div>

      <div className="contact-section">
        <h3>📍 Office Location</h3>
        <p>FLEE MAN HQ</p>
        <p>1234 Luxury Avenue, Mumbai, Maharashtra, India</p>
      </div>

      <div className="contact-section">
        <h3>⏰ Working Hours</h3>
        <p>Monday to Saturday: 9:00 AM - 8:00 PM</p>
        <p>Sunday: Closed</p>
      </div>

      <div className="contact-section">
        <h3>📬 Send us a message</h3>
        <form className="contact-form">
          <input type="text" placeholder="Your Name" required />
          <input type="email" placeholder="Your Email" required />
          <textarea rows="4" placeholder="Your Message" required></textarea>
          <button type="submit">Send Message</button>
        </form>
      </div>
    </div>
  );
};

export default ContactUs;
