import React, { useState } from "react";
import {
  Box,
  TextField,
  Select,
  MenuItem,
  Button,
  Typography,
  Grid,
  FormControl,
  InputLabel,
} from "@mui/material";
import { useNavigate } from "react-router-dom";

const RentalForm = () => {
  const [formData, setFormData] = useState({
    firstName: "",
    lastName: "",
    addressLine1: "",
    addressLine2: "",
    email: "",
    city: "",
    pincode: "",
    phoneNumber: "",
    mobileNumber: "",
    creditCardType: "",
    creditCardNumber: "",
    drivingLicenseNumber: "",
    idpNumber: "",
    issuedByDL: "",
    validThroughDL: "",
    passportNumber: "",
    passportValidFrom: "",
    passportValidThrough: "",
    passportIssuedBy: "",
    passportIssueDate: "",
    dateOfBirth: "",
  });

  const [message, setMessage] = useState("");
  const navigate = useNavigate();

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleCancel = () => {
    alert("Booking Canceled");
    navigate("/");
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    console.log("Sending to backend:", formData); // for debugging

    fetch("http://localhost:8080/addCustomer", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formData),
    })
      .then((res) => {
        if (!res.ok) throw new Error("Invalid input data");
        return res.json();
      })
      .then(() => {
        setMessage("Rental data saved successfully!");
        navigate("/ReviewDetails", { state: { formData } });
      })
      .catch((error) => {
        console.error("Error:", error);
        setMessage("❌ Error saving rental data. Check fields & try again!");
      });
  };

  // Fields you want to render as date
  const dateFields = [
    "dateOfBirth",
    "passportIssueDate",
    "passportValidFrom",
    "passportValidThrough",
    "validThroughDL",
  ];

  return (
    <Box
      sx={{
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        minHeight: "100vh",
        backgroundColor: "#f0f2f5",
        padding: 3,
      }}
    >
      <Box
        sx={{
          width: "100%",
          maxWidth: 700,
          padding: 4,
          boxShadow: 3,
          borderRadius: 2,
          backgroundColor: "#fff",
        }}
      >
        <Typography
          variant="h4"
          align="center"
          gutterBottom
          sx={{ color: "#1976d2", fontWeight: "bold" }}
        >
          Rental Form
        </Typography>

        {message && (
          <Typography align="center" color="error" sx={{ mb: 2 }}>
            {message}
          </Typography>
        )}

        <form onSubmit={handleSubmit}>
          <Grid container spacing={2}>
            {Object.keys(formData).map((key) => (
              <Grid item xs={12} sm={6} key={key}>
                {key === "creditCardType" ? (
                  <FormControl fullWidth size="small">
                    <InputLabel>Credit Card Type</InputLabel>
                    <Select
                      name="creditCardType"
                      label="Credit Card Type"
                      value={formData.creditCardType}
                      onChange={handleChange}
                      required
                    >
                      <MenuItem value="Visa">Visa</MenuItem>
                      <MenuItem value="MasterCard">MasterCard</MenuItem>
                      <MenuItem value="Amex">Amex</MenuItem>
                      <MenuItem value="Discover">Discover</MenuItem>
                    </Select>
                  </FormControl>
                ) : (
                  <TextField
                    fullWidth
                    size="small"
                    name={key}
                    label={key
                      .replace(/([A-Z])/g, " $1")
                      .replace(/^./, (str) => str.toUpperCase())}
                    type={dateFields.includes(key) ? "date" : "text"}
                    InputLabelProps={
                      dateFields.includes(key) ? { shrink: true } : {}
                    }
                    value={formData[key]}
                    onChange={handleChange}
                    required={
                      ![
                        "addressLine2",
                        "creditCardType",
                        "passportIssuedBy",
                      ].includes(key)
                    }
                  />
                )}
              </Grid>
            ))}
          </Grid>

          <Box
            sx={{ display: "flex", justifyContent: "space-between", mt: 3 }}
          >
            <Button type="submit" variant="contained" color="primary">
              Continue Booking
            </Button>
            <Button type="button" variant="outlined" color="error" onClick={handleCancel}>
              Cancel
            </Button>
          </Box>
        </form>
      </Box>
    </Box>
  );
};

export default RentalForm;
