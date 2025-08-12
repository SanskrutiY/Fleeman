import React, { useState } from "react";
import {
  Grid,
  TextField,
  Typography,
  Button,
  Paper,
  RadioGroup,
  FormControlLabel,
  Radio,
  Divider,
} from "@mui/material";
import { styled } from "@mui/system";
import { Person, CreditCard, ContactPhone } from "@mui/icons-material";
import  './Member.css'
const StyledPaper = styled(Paper)(({ theme }) => ({
  padding: "2rem",
  maxWidth: "900px",
  margin: "2rem auto",
  borderRadius: "16px",
  boxShadow: "0 8px 20px rgba(0,0,0,0.15)",
}));

const SectionHeader = ({ icon, title }) => (
  <Typography variant="h6" gutterBottom style={{ display: "flex", alignItems: "center", marginTop: "1rem" }}>
    {icon}
    <span style={{ marginLeft: "0.5rem" }}>{title}</span>
  </Typography>
);

const MembershipRegistration = () => {
  const [formData, setFormData] = useState({
    first_name: "",
    last_name: "",
    email: "",
    mobile_number: "",
    address_line1: "",
    address_line2: "",
    city: "",
    date_of_birth: "",
    gender: "Male",
    driving_license_number: "",
    issued_bydl: "",
    passport_number: "",
    passport_issue_date: "",
    idp_number: "",
    credit_card_number: "",
    credit_card_type: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Form Data Submitted:", formData);
  };

  return (
    <StyledPaper>
      <Typography variant="h4" align="center" gutterBottom>
        Membership Registration
      </Typography>

      <form onSubmit={handleSubmit}>
        <Divider />
        <SectionHeader icon={<Person />} title="Personal Details" />
        <Grid container spacing={3}>
          <Grid item xs={12} sm={6}>
            <TextField
              label="First Name"
              fullWidth
              name="first_name"
              value={formData.first_name}
              onChange={handleChange}
              variant="outlined"
              required
            />
          </Grid>

          <Grid item xs={12} sm={6}>
            <TextField
              label="Last Name"
              fullWidth
              name="last_name"
              value={formData.last_name}
              onChange={handleChange}
              variant="outlined"
              required
            />
          </Grid>

          <Grid item xs={12} sm={6}>
            <TextField
              label="Email"
              fullWidth
              name="email"
              value={formData.email}
              onChange={handleChange}
              type="email"
              variant="outlined"
              required
            />
          </Grid>

          <Grid item xs={12} sm={6}>
            <TextField
              label="Mobile Number"
              fullWidth
              name="mobile_number"
              value={formData.mobile_number}
              onChange={handleChange}
              type="tel"
              variant="outlined"
              required
            />
          </Grid>

          <Grid item xs={12}>
            <TextField
              label="Address Line 1"
              fullWidth
              name="address_line1"
              value={formData.address_line1}
              onChange={handleChange}
              variant="outlined"
              required
            />
          </Grid>

          <Grid item xs={12}>
            <TextField
              label="Address Line 2"
              fullWidth
              name="address_line2"
              value={formData.address_line2}
              onChange={handleChange}
              variant="outlined"
            />
          </Grid>

          <Grid item xs={12} sm={6}>
            <TextField
              label="City"
              fullWidth
              name="city"
              value={formData.city}
              onChange={handleChange}
              variant="outlined"
            />
          </Grid>

          <Grid item xs={12} sm={6}>
            <TextField
              label="Date of Birth"
              fullWidth
              name="date_of_birth"
              type="date"
              InputLabelProps={{ shrink: true }}
              value={formData.date_of_birth}
              onChange={handleChange}
              variant="outlined"
            />
          </Grid>

          <Grid item xs={12}>
            <Typography variant="body1">Gender</Typography>
            <RadioGroup
              row
              name="gender"
              value={formData.gender}
              onChange={handleChange}
            >
              <FormControlLabel value="Male" control={<Radio />} label="Male" />
              <FormControlLabel value="Female" control={<Radio />} label="Female" />
              <FormControlLabel value="Other" control={<Radio />} label="Other" />
            </RadioGroup>
          </Grid>
        </Grid>

        <Divider sx={{ my: 3 }} />
        <SectionHeader icon={<ContactPhone />} title="License & Passport Details" />

        <Grid container spacing={3}>
          <Grid item xs={12} sm={6}>
            <TextField
              label="Driving License Number"
              fullWidth
              name="driving_license_number"
              value={formData.driving_license_number}
              onChange={handleChange}
              variant="outlined"
            />
          </Grid>

          <Grid item xs={12} sm={6}>
            <TextField
              label="Issued By"
              fullWidth
              name="issued_bydl"
              value={formData.issued_bydl}
              onChange={handleChange}
              variant="outlined"
            />
          </Grid>

          <Grid item xs={12} sm={6}>
            <TextField
              label="Passport Number"
              fullWidth
              name="passport_number"
              value={formData.passport_number}
              onChange={handleChange}
              variant="outlined"
            />
          </Grid>

          <Grid item xs={12} sm={6}>
            <TextField
              label="Passport Issue Date"
              fullWidth
              name="passport_issue_date"
              type="date"
              InputLabelProps={{ shrink: true }}
              value={formData.passport_issue_date}
              onChange={handleChange}
              variant="outlined"
            />
          </Grid>

          <Grid item xs={12}>
            <TextField
              label="IDP Number"
              fullWidth
              name="idp_number"
              value={formData.idp_number}
              onChange={handleChange}
              variant="outlined"
            />
          </Grid>
        </Grid>

        <Divider sx={{ my: 3 }} />
        <SectionHeader icon={<CreditCard />} title="Credit Card Details" />

        <Grid container spacing={3}>
          <Grid item xs={12} sm={6}>
            <TextField
              label="Credit Card Number"
              fullWidth
              name="credit_card_number"
              value={formData.credit_card_number}
              onChange={handleChange}
              variant="outlined"
            />
          </Grid>

          <Grid item xs={12} sm={6}>
            <TextField
              label="Credit Card Type"
              fullWidth
              name="credit_card_type"
              value={formData.credit_card_type}
              onChange={handleChange}
              variant="outlined"
            />
          </Grid>
        </Grid>

        <div style={{ marginTop: "2rem", textAlign: "center" }}>
                  <button className="custom-button" type="submit">
                      <span className="transition"></span>
                      <span className="gradient"></span>
                      <span className="label">Register</span>
                  </button>
              </div>

      </form>
    </StyledPaper>
  );
};

export default MembershipRegistration;
