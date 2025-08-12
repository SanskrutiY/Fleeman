import React, { useState, useEffect } from "react";
import { Form, Button, Container, Card } from "react-bootstrap";
import { useNavigate } from "react-router-dom";

function RentalAddons() {
  const [addons, setAddons] = useState([]);
  const [selectedAddons, setSelectedAddons] = useState({});
  const [childSeats, setChildSeats] = useState(0);
  const [enableChildSeats, setEnableChildSeats] = useState(false);
  const [totalAmount, setTotalAmount] = useState(0);

  const navigate = useNavigate();

  // Fetch add-ons from backend
  useEffect(() => {
    const fetchAddons = async () => {
      try {
        const response = await fetch("http://localhost:8080/addon");
        if (response.ok) {
          const data = await response.json();
          setAddons(data);
        } else {
          console.error("Failed to fetch add-ons");
        }
      } catch (error) {
        console.error("Error fetching add-ons:", error);
      }
    };

    fetchAddons();
  }, []);

  // Handle checkbox change for regular add-ons
  const handleAddonChange = (id) => {
    setSelectedAddons((prev) => ({
      ...prev,
      [id]: !prev[id],
    }));
  };

  // Reset form
  const handleCancel = () => {
    setSelectedAddons({});
    setEnableChildSeats(false);
    setChildSeats(0);
    setTotalAmount(0);
  };

  // Calculate and save selection
  const handleSubmit = (e) => {
    e.preventDefault();

    let amount = 0;
    const selectedDetails = [];

    addons.forEach((addon) => {
      if (selectedAddons[addon.addOnId]) {
        amount += addon.addOnDailyRate;
        selectedDetails.push({
          add_on_name: addon.addOnName,
          add_on_daily_rate: addon.addOnDailyRate,
          rate_valid_until: addon.rateValidUntil,
        });
      }
    });

    if (enableChildSeats && childSeats > 0) {
      const freeSeats = 1;
      const ratePerSeat = 200;
      const extraSeats = Math.max(0, childSeats - freeSeats);
      const childCost = extraSeats * ratePerSeat;

      amount += childCost;

      selectedDetails.push({
        add_on_name: "Child Seats",
        add_on_daily_rate: childCost,
        rate_valid_until: new Date().toISOString(),
      });
    }

    setTotalAmount(amount);

    sessionStorage.setItem("selectedAddons", JSON.stringify(selectedDetails));
    sessionStorage.setItem("totalAddonsAmount", amount);

    navigate("/RentalForm");
  };

  return (
    <Container className="mt-5" style={{ maxWidth: "500px" }}>
      <h2 className="text-center mb-4 bg-primary text-white p-2 rounded">
        Rental Add-ons
      </h2>

      <Card className="shadow">
        <Card.Body>
          <Form onSubmit={handleSubmit}>
            {addons.map((addon) => (
              <Form.Group controlId={`addon-${addon.addOnId}`} key={addon.addOnId} className="mb-2">
                <Form.Check
                  type="checkbox"
                  label={`${addon.addOnName} - Rs.${addon.addOnDailyRate}/day`}
                  checked={!!selectedAddons[addon.addOnId]}
                  onChange={() => handleAddonChange(addon.addOnId)}
                />
              </Form.Group>
            ))}

            <hr />

            <Form.Group controlId="enableChildSeats" className="mb-2">
              <Form.Check
                type="checkbox"
                label="Child Seats - Rs.200/day (1 seat free)"
                checked={enableChildSeats}
                onChange={(e) => setEnableChildSeats(e.target.checked)}
              />
            </Form.Group>

            

            <div className="d-flex justify-content-between mt-4" style={{ gap: "1rem" }}>
              <Button variant="primary" type="submit" className="w-100">
                Continue Booking
              </Button>
              <Button variant="secondary" onClick={handleCancel} className="w-100">
                Cancel
              </Button>
            </div>

            {totalAmount > 0 && (
              <div className="mt-4 text-center">
                <h5>Total Add-on Amount: Rs.{totalAmount}</h5>
              </div>
            )}
          </Form>
        </Card.Body>
      </Card>
    </Container>
  );
}

export default RentalAddons;
