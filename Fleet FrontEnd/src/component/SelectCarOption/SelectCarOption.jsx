import React, { useEffect, useState } from "react";
import {
  Container,
  Typography,
  Grid,
  Card,
  CardMedia,
  CardContent,
  CardActions,
  Button,
  CircularProgress,
  Box,
  Select,
  MenuItem,
  InputLabel,
  FormControl,
} from "@mui/material";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const SelectCarOption = () => {
  const [carList, setCarList] = useState([]);
  const [carTypes, setCarTypes] = useState([]);
  const [selectedCarType, setSelectedCarType] = useState("");
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchCarTypes = async () => {
      try {
        const response = await axios.get("http://localhost:8080/api/v1/cartypes");
        console.log("Fetched car types:", response.data);
        setCarTypes(response.data);
      } catch (error) {
        console.error("Error fetching car types: ", error);
        alert("Failed to fetch car types.");
      }
    };

    fetchCarTypes();
  }, []);

  const handleCarTypeChange = async (event) => {
    const selectedTypeId = event.target.value;
    setSelectedCarType(selectedTypeId);
    setLoading(true);

    try {
      const pickupDate = sessionStorage.getItem("pickupDate");
      const pickupTime = sessionStorage.getItem("pickupTime");
      const dropDate = sessionStorage.getItem("dropDate");
      const dropTime = sessionStorage.getItem("dropTime");
      const hubId = sessionStorage.getItem("hubId");

      const res = await axios.get("http://localhost:8080/api/v1/cars", {
        params: {
          pickupDate,
          pickupTime,
          dropDate,
          dropTime,
          hubId,
          carTypeId: selectedTypeId,
        },
      });

      setCarList(res.data);
    } catch (error) {
      console.error("Error fetching available cars: ", error);
      alert("Failed to fetch cars.");
    } finally {
      setLoading(false);
    }
  };

 const handleSelectCar = (car) => {
  sessionStorage.setItem("selectedCar", JSON.stringify(car)); // (optional backup)
  navigate("/RentalForm", { state: { selectedCar: car } }); // ✅ Proper navigation with selectedCar
};


  return (
    <Container>
      <Typography variant="h4" align="center" sx={{ mt: 4, fontWeight: "bold" }}>
        Select Your Car Type
      </Typography>

      <FormControl fullWidth sx={{ mt: 4 }}>
  <InputLabel id="car-type-label">Car Type</InputLabel>
  <Select
    labelId="car-type-label"
    value={selectedCarType}
    label="Car Type"
    onChange={handleCarTypeChange}
    sx={{ bgcolor: "#f1f1f1" }} // ✅ subtle background
  >
    {carTypes.map((type) => (
      <MenuItem key={type.cartype_id} value={type.cartype_id}>
        {type.cartype_name}
      </MenuItem>
    ))}
  </Select>
</FormControl>


      {loading ? (
        <Box textAlign="center" mt={5}>
          <CircularProgress />
        </Box>
      ) : carList.length > 0 ? (
        <>
          <Typography variant="h5" align="center" sx={{ mt: 5 }}>
            Available Cars
          </Typography>
          <Grid container spacing={3} sx={{ mt: 2 }}>
            {carList.map((car) => (
              <Grid item xs={12} sm={6} md={4} key={car.carId}>
                <Card sx={{ boxShadow: 3, transition: "0.3s", "&:hover": { transform: "scale(1.03)" } }}>
                  <CardMedia
                    component="img"
                    height="180"
                    image={car.carImage || "https://via.placeholder.com/300x180.png?text=Car+Image"}
                    alt={car.carName}
                  />
                  <CardContent>
                    <Typography variant="h6" fontWeight="bold" gutterBottom>
                      {car.carName}
                    </Typography>
                    <Typography variant="body2">Fuel: {car.fuelType}</Typography>
                    <Typography variant="body2">Seats: {car.noOfSeats}</Typography>
                    <Typography variant="body2" sx={{ mt: 1 }}>
                      ₹{car.daily ? Number(car.daily).toFixed(2) : "N/A"} / day
                    </Typography>
                  </CardContent>
                  <CardActions>
                    <Button
                      variant="contained"
                      fullWidth
                      onClick={() => handleSelectCar(car)}
                    >
                      Select
                    </Button>
                  </CardActions>
                </Card>
              </Grid>
            ))}
          </Grid>
        </>
      ) : selectedCarType !== "" ? (
        <Typography variant="h6" color="error" align="center" sx={{ mt: 4 }}>
          No cars available for the selected type.
        </Typography>
      ) : null}
    </Container>
  );
};

export default SelectCarOption;
