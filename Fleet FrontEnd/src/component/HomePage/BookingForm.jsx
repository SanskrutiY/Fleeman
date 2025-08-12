import React from "react";
import dayjs from "dayjs";
import { useNavigate } from "react-router-dom";
import "./BookingForm.css";

export const BookingForm = () => {
  const navigate = useNavigate();

  const [statesData, setStatesData] = React.useState([]);
  const [citiesData, setCitiesData] = React.useState([]);
  const [rentalDate, setRentalDate] = React.useState(dayjs().format("YYYY-MM-DD"));
  const [rentalTime, setRentalTime] = React.useState(dayjs().format("HH:mm"));
  const [returnDate, setReturnDate] = React.useState(dayjs().format("YYYY-MM-DD"));
  const [returnTime, setReturnTime] = React.useState(dayjs().format("HH:mm"));
  const [pickupState, setPickupState] = React.useState("");
  const [pickupCity, setPickupCity] = React.useState("");
  const [pickupAirportCode, setPickupAirportCode] = React.useState("");
  const [returnState, setReturnState] = React.useState("");
  const [returnCity, setReturnCity] = React.useState("");
  const [returnAirportCode, setReturnAirportCode] = React.useState("");
  const [sameLocation, setSameLocation] = React.useState(false);
  const [errors, setErrors] = React.useState({});
  const [openSnackbar, setOpenSnackbar] = React.useState(false);
  const [searchOption, setSearchOption] = React.useState("cityState");

  React.useEffect(() => {
    const fetchStatesData = async () => {
      try {
        const res = await fetch("http://localhost:8080/State");
        const data = await res.json();
        setStatesData(data);
      } catch (error) {
        console.error("❌ Error fetching states:", error);
      }
    };
    fetchStatesData();
  }, []);

  const fetchCitiesData = async (stateId) => {
    try {
      const res = await fetch(`http://localhost:8080/city/${stateId}`);
      const data = await res.json();
      const filtered = data.filter((city) => city.state.stateId === stateId);
      setCitiesData(filtered);
    } catch (error) {
      console.error("❌ Error fetching cities:", error);
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const isLoggedIn = sessionStorage.getItem("isLoggedIn") === "true";
    if (!isLoggedIn) {
      setOpenSnackbar(true);
      return;
    }

    let formErrors = {};
    if (searchOption === "cityState") {
      if (!pickupState) formErrors.pickupState = "Pick-Up State is required.";
      if (!pickupCity) formErrors.pickupCity = "Pick-Up City is required.";
    } else if (searchOption === "airport" && !pickupAirportCode.trim()) {
      formErrors.pickupAirportCode = "Airport Code is required.";
    }

    if (!rentalDate || !rentalTime) {
      formErrors.rentalDateTime = "Pick-Up Date & Time are required.";
    }

    if (sameLocation) {
      if (searchOption === "cityState") {
        if (!returnState) formErrors.returnState = "Return State is required.";
        if (!returnCity) formErrors.returnCity = "Return City is required.";
      } else if (searchOption === "airport" && !returnAirportCode.trim()) {
        formErrors.returnAirportCode = "Return Airport Code is required.";
      }

      if (!returnDate || !returnTime) {
        formErrors.returnDateTime = "Return Date & Time are required.";
      }
    }

    setErrors(formErrors);
    if (Object.keys(formErrors).length !== 0) return;

    try {
      const res = await fetch(
        `http://localhost:8080/api/v1/hub?stateName=${pickupState.stateName}&cityName=${pickupCity}`
      );
      const hubData = await res.json();

      if (!hubData || hubData.length === 0) {
        alert("⚠️ No hubs found for the selected location.");
        return;
      }

      sessionStorage.setItem("hubData", JSON.stringify(hubData));
      sessionStorage.setItem("pickupDate", rentalDate);
      sessionStorage.setItem("pickupTime", rentalTime);
      sessionStorage.setItem("dropDate", returnDate);
      sessionStorage.setItem("dropTime", returnTime);
      sessionStorage.setItem("hubId", hubData[0].hubId);

      sessionStorage.setItem("bookingDetails", JSON.stringify({
        rentalDate,
        rentalTime,
        returnDate,
        returnTime,
        pickupState,
        pickupCity,
        pickupAirportCode,
        returnState,
        returnCity,
        returnAirportCode,
        sameLocation,
        searchOption
      }));

      navigate("/selectLocation");
    } catch (err) {
      console.error("❌ Error fetching hub data:", err);
    }
  };

  return (
    <div className="container mt-5 p-4 bg-white rounded shadow-lg">
      <h2 className="text-center mb-4 fw-bold text-primary">Book Your Rental Car</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label className="form-label fw-bold">Pick-Up Location</label>
          <div className="form-check form-check-inline">
            <input
              className="form-check-input"
              type="radio"
              name="searchOption"
              id="cityStateOption"
              value="cityState"
              checked={searchOption === "cityState"}
              onChange={() => setSearchOption("cityState")}
            />
            <label className="form-check-label" htmlFor="cityStateOption">
              City & State
            </label>
          </div>
          <div className="form-check form-check-inline">
            <input
              className="form-check-input"
              type="radio"
              name="searchOption"
              id="airportOption"
              value="airport"
              checked={searchOption === "airport"}
              onChange={() => setSearchOption("airport")}
            />
            <label className="form-check-label" htmlFor="airportOption">
              Airport Code
            </label>
          </div>

          {searchOption === "cityState" && (
            <>
              <select
                className={`form-select mt-2 ${errors.pickupState ? "is-invalid" : ""}`}
                value={pickupState.stateId || ""}
                onChange={(e) => {
                  const selected = statesData.find(s => s.stateId === parseInt(e.target.value));
                  setPickupState(selected);
                  setPickupCity("");
                  fetchCitiesData(selected?.stateId);
                }}
              >
                <option value="">Select State</option>
                {statesData.map((state) => (
                  <option key={state.stateId} value={state.stateId}>
                    {state.stateName}
                  </option>
                ))}
              </select>
              {errors.pickupState && <div className="invalid-feedback d-block">{errors.pickupState}</div>}

              <select
                className={`form-select mt-2 ${errors.pickupCity ? "is-invalid" : ""}`}
                value={pickupCity}
                onChange={(e) => setPickupCity(e.target.value)}
                disabled={!pickupState}
              >
                <option value="">Select City</option>
                {citiesData.map((city) => (
                  <option key={city.cityId} value={city.cityName}>
                    {city.cityName}
                  </option>
                ))}
              </select>
              {errors.pickupCity && <div className="invalid-feedback d-block">{errors.pickupCity}</div>}
            </>
          )}

          {searchOption === "airport" && (
            <>
              <input
                type="text"
                className={`form-control mt-2 ${errors.pickupAirportCode ? "is-invalid" : ""}`}
                placeholder="Enter Airport Code"
                value={pickupAirportCode}
                onChange={(e) => setPickupAirportCode(e.target.value.toUpperCase())}
              />
              {errors.pickupAirportCode && <div className="invalid-feedback d-block">{errors.pickupAirportCode}</div>}
            </>
          )}
        </div>

        <div className="row mb-3">
          <div className="col-md-6">
            <label className="form-label fw-bold">Pick-Up Date</label>
            <input
              type="date"
              className={`form-control ${errors.rentalDateTime ? "is-invalid" : ""}`}
              value={rentalDate}
              onChange={(e) => setRentalDate(e.target.value)}
            />
          </div>
          <div className="col-md-6">
            <label className="form-label fw-bold">Pick-Up Time</label>
            <input
              type="time"
              className={`form-control ${errors.rentalDateTime ? "is-invalid" : ""}`}
              value={rentalTime}
              onChange={(e) => setRentalTime(e.target.value)}
            />
          </div>
          {errors.rentalDateTime && <div className="invalid-feedback d-block">{errors.rentalDateTime}</div>}
        </div>

        <div className="form-check mb-4">
          <input
            className="form-check-input"
            type="checkbox"
            id="sameLocationCheck"
            checked={sameLocation}
            onChange={() => setSameLocation(!sameLocation)}
          />
          <label className="form-check-label fw-bold" htmlFor="sameLocationCheck">
            I may drop the car at a different location
          </label>
        </div>

        {sameLocation && (
          <>
            <div className="mb-3">
              <label className="form-label fw-bold">Return Location</label>
              {searchOption === "cityState" && (
                <>
                  <select
                    className={`form-select mt-2 ${errors.returnState ? "is-invalid" : ""}`}
                    value={returnState.stateId || ""}
                    onChange={(e) => {
                      const selected = statesData.find(s => s.stateId === parseInt(e.target.value));
                      setReturnState(selected);
                      setReturnCity("");
                      fetchCitiesData(selected?.stateId);
                    }}
                  >
                    <option value="">Select State</option>
                    {statesData.map((state) => (
                      <option key={state.stateId} value={state.stateId}>
                        {state.stateName}
                      </option>
                    ))}
                  </select>
                  {errors.returnState && <div className="invalid-feedback d-block">{errors.returnState}</div>}

                  <select
                    className={`form-select mt-2 ${errors.returnCity ? "is-invalid" : ""}`}
                    value={returnCity}
                    onChange={(e) => setReturnCity(e.target.value)}
                    disabled={!returnState}
                  >
                    <option value="">Select City</option>
                    {citiesData.map((city) => (
                      <option key={city.cityId} value={city.cityName}>
                        {city.cityName}
                      </option>
                    ))}
                  </select>
                  {errors.returnCity && <div className="invalid-feedback d-block">{errors.returnCity}</div>}
                </>
              )}
              {searchOption === "airport" && (
                <>
                  <input
                    type="text"
                    className={`form-control mt-2 ${errors.returnAirportCode ? "is-invalid" : ""}`}
                    placeholder="Enter Return Airport Code"
                    value={returnAirportCode}
                    onChange={(e) => setReturnAirportCode(e.target.value.toUpperCase())}
                  />
                  {errors.returnAirportCode && <div className="invalid-feedback d-block">{errors.returnAirportCode}</div>}
                </>
              )}
            </div>

            <div className="row mb-4">
              <div className="col-md-6">
                <label className="form-label fw-bold">Return Date</label>
                <input
                  type="date"
                  className={`form-control ${errors.returnDateTime ? "is-invalid" : ""}`}
                  value={returnDate}
                  onChange={(e) => setReturnDate(e.target.value)}
                />
              </div>
              <div className="col-md-6">
                <label className="form-label fw-bold">Return Time</label>
                <input
                  type="time"
                  className={`form-control ${errors.returnDateTime ? "is-invalid" : ""}`}
                  value={returnTime}
                  onChange={(e) => setReturnTime(e.target.value)}
                />
              </div>
              {errors.returnDateTime && <div className="invalid-feedback d-block">{errors.returnDateTime}</div>}
            </div>
          </>
        )}

        <div className="text-center mt-4">
          <button type="submit" className="btn btn-lg btn-gradient px-5">
            Search Rental Cars
          </button>
        </div>
      </form>

      {openSnackbar && (
        <div className="alert alert-warning alert-dismissible fade show mt-4" role="alert">
          Please log in to search for rental cars.
          <button type="button" className="btn-close" aria-label="Close" onClick={() => setOpenSnackbar(false)}></button>
        </div>
      )}
    </div>
  );
};
